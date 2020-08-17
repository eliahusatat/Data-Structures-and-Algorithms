package sort;

import java.util.Arrays;

public class quick_sort {
	
	/**
	 * the UI function
	 * @param arr - the array to sort
	 */
	public static void quickSort(int arr []) {
		quickSortHelp(arr,0,arr.length-1);
	}
	
	private static void quickSortHelp(int arr [] , int left, int right) {
		if(left >= right) { // the recursion condition
			return;
		}
		int pivot = arr[(right + left)/2]; // peek pivot to be the middle 
		int index = partition(arr , left ,right , pivot); // swap the element from left to right according to the pivot
		quickSortHelp(arr,left ,index -1); // call recursion on each side
		quickSortHelp(arr,index, right);
		
	}
	private static int partition(int arr [], int left, int right , int pivot) {
		while(left <= right) {
			while(arr[left] < pivot) {// find the next element from left to swap
				left++;
			}
			while(arr[right] > pivot) {// find the next element from right to swap
				right--;
			}
			if(left <= right) { 
				swap(arr , left ,right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
	    arr[right] = temp;
	}

	public static void main(String[] args) {
		int arr []= {1,2,5,3,8,4,23,5,2458,2,1,2357,65}; 
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
