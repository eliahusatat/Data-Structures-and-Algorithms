package sort;

import java.util.Arrays;
/**
 * this class implements bubble sort - O(N^2)
 * @author Eliahu Satat
 */

public class bubble_sort {
	
	/**
	 * this function make bubble sort - O(N^2)
	 * @param arr
	 */
	public static void bubbleSort(int arr []) {
		boolean isSorted = false;
		int last_not_sort = arr.length -1; 
		while(!isSorted) { // if we finish all iteration without swapping - the array is sorted
			isSorted = true; // assuming the array is sort
			for (int i = 0; i < last_not_sort; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i ,i+1);
					isSorted = false;
				}
			}
			last_not_sort --; // after each iteration the last element is in his right place
		}
		
	}
	
	private static void swap (int arr [], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void main(String[] args) {
		int arr []= {1,2,5,3,8,4,23,5,2458,2,1,2357,65}; 
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
