package com.equinix.algos;

public class PrimeNumbers {
	public static void main(String[] args) {
		int n =100;
		//System.out.println((6%2));
		long t = System.nanoTime();
		int primes[] = new int[1000];
		primes[0] = 2;
		System.out.println(primes[0]);
		int primeCnt = 1;
		for (int i = 3; i <= n; i++) {
			int j =0;
			for(;j<primeCnt;j++){
				if(primes[j]*primes[j] > i){
					/*test purpose
					 * if(i==997)
						System.out.println(j);*/
					j = primeCnt;
					break;
				}
				if(i%primes[j] == 0)
					break;
			}
			if(j == primeCnt){
				System.out.println(i);
				primes[j] = i;
				primeCnt++;
			}
		}
		
		
		//System.out.println(primeCnt);
		System.out.println("*****************"+(System.nanoTime()-t));
		t = System.nanoTime();
		sievePrimes(n);
		System.out.println("*****************"+(System.nanoTime()-t));
		
	}
	
	private static void sievePrimes(int n){
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		int j=1;
		for (int i = 2; j<n && (arr[j] * i) <= n ; ) {
			arr[(arr[j] * i) -1] = -1;
			i++;
			if( (arr[j] * i) > n ){
				j++;
				while(j<n){
					if(arr[j]>-1){
						i=2;
						break;
					}j++;
						
				}
			}
		}
		
		for (int i = 1; i < n ; i++) {
			if(arr[i]>-1)
				System.out.println(arr[i]);
		}
		
	}
	
	
}
