package com.equinix.algos;

public class TrainPlatform {
	public static void main(String[] args) {
		int n = 4;
		/*int arr[]  = {900,  940, 950,  1100, 1100, 1800};
        int dep[]  = {910, 1200, 1120, 1130, 1900, 2000};
        */
		int arr[]  = {1,3,2,5};
        int dep[]  = {4,5,7,10};
        
        
        QuickSort.quickSort(arr, 0, arr.length-1);
        QuickSort.quickSort(dep, 0, dep.length-1);
        System.out.println("*******************");
        for (int i : arr) {
        	System.out.print(i+"->");	
		}
        
        System.out.println("*******************");
        for (int i : dep) {
        	System.out.print(i+"->");	
		}
        System.out.println("*******************");
        
        
        System.out.println(platFormsNeeded(arr,dep,n));
        
        
	}

	private static int platFormsNeeded(int[] arr, int[] dep,int totalTrains) {
		int aL = 0;//arr.length;
		int dL = 0;//dep.length;
		int platformNeeded = 0;
		int max = 0;
		while(aL<totalTrains && dL<totalTrains){
			if(arr[aL] < dep[dL]){
				platformNeeded++;
				aL++;
			}else{
				platformNeeded--;
				dL++;
			}
			max = Math.max(platformNeeded, max);
		}
		return max;
	}
	
	
	
}
