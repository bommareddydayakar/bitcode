package com.equinix.algos;

public class ArrayRotate {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		rotateArray(a,36);
			
	}

	private static void rotateArray(int[] a, int timesToRotate) {
		
		if(a != null && a.length > 0){
			int[] target = new int[a.length]; 
			int length = a.length;
			for (int i = 0; i < target.length; i++) {
				//System.out.println(timesToRotate%a.length);
				target[(timesToRotate++%a.length)] = a[i];
			}
			
			
			
			for (int i = 0; i < target.length; i++) {
				System.out.println(target[i]);
			}
			
		}
		
	}	
}
