package search;

public class binary_search {

	public static boolean binarySearchRecursive(int [] arr,int x) {
		return binarySearchRecursive(arr , x ,  0 ,arr.length-1);
	}
	private static boolean binarySearchRecursive(int [] arr,int x, int start , int end) {
		if(start > end) {
			return false;
		}
		int mid = start + ((end - start)/2) ;
		if(arr[mid] == x) return true;
		if(arr[mid] > x) return binarySearchRecursive(arr ,x ,start , mid -1);
		if(arr[mid] < x) return binarySearchRecursive(arr ,x ,mid+1 , end);
		return false;
	}
	public static boolean binarySearchIterative(int [] arr,int x) {
		int start = 0;
		int end =arr.length-1;
		while(start <= end) {
			int mid = start + ((end - start)/2) ;
			if(arr[mid] == x) return true;
			if(arr[mid] > x) { end = mid - 1;}
			if(arr[mid] < x) {start = mid + 1;};
		}
		return false;
	}

	public static void main(String[] args) {
		int arr [] = {1,2,3};
		System.out.println(binarySearchIterative(arr ,3));
		System.out.println(binarySearchIterative(arr ,5));
		int [] arr1 = {0};
		System.out.println(binarySearchIterative(arr1 ,3));
		System.out.println(binarySearchIterative(arr1 ,0));
		int [] arr2 = {};
		System.out.println(binarySearchIterative(arr2 ,3));


	}

}
