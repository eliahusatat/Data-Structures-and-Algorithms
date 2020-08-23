package Bitwise_operations;

public class bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 99;
		System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(setToZero(b,6)));
        int arr [] = {1,2,3,4,5};
        maxOpertors(arr);
	}
	
	
	
	/**
	 * this function checks if some bit is one
	 * @param b some binary number
	 * @param i index for the bit to check
	 * @return if the i's bit is one
	 */
	public static boolean isTheBitIsOne(byte  b,int i) {
        byte a = 1;
        a = (byte) (a << i);
        return ((b&a )!=0);
	}
	
	
	/**
	 * this function set some bit to one
	 * @param b some binary number
	 * @param i index for the bit to set
	 * @return the new number after setting the i's bit to one
	 */
	public static byte setToOne(byte  b,int i) {
        byte a = 1;
        a = (byte) (a << (i-1));
        return (byte) (b|a);
	}
	
	/**
	 * this function set some bit to zero
	 * @param b some binary number
	 * @param i index for the bit to set
	 * @return the new number after setting the i's bit to zero
	 */
	public static byte setToZero(byte  b,int i) {
        byte a = 1;
        a = (byte) (a << (i-1));
        a =(byte) ~ a;
        return (byte) (b&a);
	}
	
	
	/**
	 * this function find the max (a or b) (a and b) (a xor b)
	 * from all a and b in the array where a<b
	 * @param arr - sorted array of integers
	 */
	public static void maxOpertors(int [] arr) {
		int maxOr = arr[0]|arr[1];
		int maxAnd = arr[0]&arr[1];
		int maxXor = arr[0]^arr[1];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if((arr[i]|arr[j]) > maxOr) {
					maxOr = (arr[i]|arr[j]);
				}
				if((arr[i]|arr[j]) > maxAnd) {
					maxAnd = (arr[i]&arr[j]);
				}
				if((arr[i]|arr[j]) > maxXor) {
					maxXor = (arr[i]^arr[j]);
				}
			}
		}
		
		System.out.println("max or: "+maxOr);
		System.out.println("max and: "+maxAnd);
		System.out.println("max xor: "+maxXor);
		
	}

}
