package com.daya.algos.dynamicprog;

import java.util.Arrays;

public class BoxStacking {
	public static void main(String[] args) {
		int[][] boxes = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
		//Prepare 3 boxes
		Box[] arr = new Box[boxes.length];
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes[i].length; ) {
				Box b = new Box(boxes[i][j++],boxes[i][j++],boxes[i][j++]);
				arr[i] = b;
			}
		}
		System.out.println("Max Stack Height is?"+maxStackHeight(arr,arr.length));
	}

	private static int maxStackHeight(Box[] arr, int length) {
		//Prepare all 3 variants for each box.
		// Each box will have 3 variants
		Box[] arrVar = new Box[arr.length*3];
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			//First Variant intact. No change. 
			arrVar[j++] = arr[i];
			Box b = new Box(arr[i].w,Math.min(arr[i].d,arr[i].h),Math.max(arr[i].d,arr[i].h));
			arrVar[j++] = b;
			b = new Box(arr[i].d,Math.min(arr[i].h,arr[i].w),Math.max(arr[i].h,arr[i].w));
			arrVar[j++] = b;
		}
		//Sort all variants of the boxes 
		Arrays.sort(arrVar);
		
		for (Box box : arrVar) {
			//System.out.println(box.h+":"+box.w+":"+box.d);
			System.out.println(box);
			
		}
		int n = arrVar.length;
		int[] res = new int[n];
		for (int i = 0; i < arrVar.length; i++) {
			res[i] = arrVar[i].h;
		}
		for (int i = 0; i < arrVar.length; i++) {
			for (int k = 0; k < i; k++) {
				//if(arrVar[k].w <= arrVar[i].w && arrVar[k].d <= arrVar[i].d && res[i]<res[k]+arrVar[i].h){
				if(arrVar[k].w < arrVar[i].w && arrVar[k].d < arrVar[i].d && res[i]<res[k]+arrVar[i].h){
					res[i] = res[k]+arrVar[i].h;//Math.max(res[i], res[k]+arrVar[i].h);
				}
			}
			res[i] = Math.max(res[i], arrVar[i].h);
			
		}
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
		return 0;
	}
}
class Box implements Comparable<Box>{
	int h;
	int w;
	int d;
	public Box(int h,int w,	int d){
		this.h = h;
		this.w = w;
		this.d = d;
	}
	@Override
	public int compareTo(Box o) {
		return (this.w*this.d)-(o.w*o.d);
		//return (o.w*o.d) - (this.w*this.d);
	}

	@Override
	public String toString() {
		return this.h+"<->"+this.w+"<->"+this.d;
	}
	
}

