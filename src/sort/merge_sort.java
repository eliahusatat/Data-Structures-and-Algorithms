package sort;

import java.util.Arrays;
/**
 * this class implements merge sort O(NLog(N))
 * @author Eliahu Satat
 */

public class merge_sort {

	
	/**
	 *  the UI function
	 * @param arr - the array to sort
	 */
	public static void mergeSort(int arr []) {
		mergeSort(arr , new int [arr.length], 0 , arr.length -1);
	}

	
	/**
	 * @param arr - the array to sort
	 * @param temp - temporary array (always the same - to save space)
	 * @param leftStart - index to the start position for the sorting 
	 * @param rightEnd - index to the end position for the sorting
	 */
	private static void mergeSort(int arr [], int [] temp ,int leftStart , int rightEnd) {
		if(leftStart >= rightEnd) { // if the indexes equal - we finish
			return ;
		}
		else {
			int middle = (leftStart + rightEnd)/2;
			mergeSort(arr ,temp,  leftStart , middle ); // sort left side
			mergeSort(arr ,temp, middle +1 , rightEnd);// sort right side
			merge(arr , temp, leftStart ,  rightEnd); // merge them together
		}
	}
	
	
	/**
	 * this function merge two sides of the array to one 
	 * @param arr the array to merge
	 * @param temp - temporary help array
	 * @param leftStart - start index to merge
	 * @param rightEnd - end index to merge
	 */
	private static void merge(int arr [],int temp [], int leftStart , int rightEnd) {
		int leftEnd = (leftStart + rightEnd)/2; // the end of the left array 
		int rightStart = leftEnd + 1; // the start of the right array 
        int size = rightEnd - leftStart + 1; // the size of the all array
		int left = leftStart;
		int right =  rightStart;
		int index = leftStart;
		while((left <= leftEnd)&&(right <= rightEnd)) { // merging them to temp
			if(arr[left]<= arr[right]) {
				temp[index++] = arr[left++];
			}
			else {
				temp[index++] = arr[right++];
			}
		}
		
		while(left <= leftEnd) { // if we didn't finish with the left side
			temp[index++] = arr[left++];
		}
		while(right <= rightEnd) { // if we didn't finish with the right side
			temp[index++] = arr[right++];
		}
		System.arraycopy(temp, leftStart, arr, leftStart, size); // copy from them to the original arr
	}

	/**
	 * swapping function
	 */
	private static void swap(int arr [], int index1 ,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;

	}


	public static void main(String[] args) {
		int arr []= {1,2,5,3,8,4,23,5,2458,2,1,2357,65}; 
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
