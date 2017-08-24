package com.daya.algos.greedy;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

	public static void main(String[] args) {
		int[][] arr = { 
				{ 1, 4 },
				{ 3, 5 },
				{ 0, 6 },
				{ 5, 7 },
				{ 3, 8 },
				{ 5, 9 },
				{ 6, 10 },
				{ 8, 11 },
				{ 8, 12 },
				{ 2, 13 },
				{ 12, 14 },
				{ 14, 14 },
				
			};
		
		Activity[] acts = new Activity[arr.length];
		for (int i = 0; i < arr.length; i++) {
			Activity act = new Activity(arr[i][0],arr[i][1]);
			acts[i] = act;
		}
		
		acts = mergeSort(acts);
		for (Activity job : acts) {
			System.out.print(job.st+":"+job.et+"<<-->>");
		}
		System.out.println("*********************************");
		System.out.println(findMaxActivities(acts,0,0));
	}
	
	
	private static List<Activity> findMaxActivities(Activity[] acts, int stTime, int stInd) {
		if(acts == null || acts.length ==0)
			return null;
		//Activity[] subList = new Activity[acts.length];
		
		
		Activity  selItm  = null;
		List<Activity>  exSubList  = new ArrayList<Activity>();
		
		for (int i = stInd; i < acts.length; i++) {
			Activity curAct = acts[i];
			if(curAct.st >= stTime){
				selItm = curAct;
				List<Activity> tmpList = new ArrayList<Activity>();
				tmpList.add(curAct);
						tmpList.addAll(findMaxActivities(acts, curAct.et,i+1)); 
				if(exSubList.size() < tmpList.size()){
					exSubList = tmpList;
				}
			}
		}
		
		return exSubList;
	}

	private static int getMaxActivityTime(Activity[] acts) {
		if(acts == null || acts.length ==0)
			return 0;
		int max = 0;
		for (int i = 0; i < acts.length; i++) {
			max = Math.max(acts[i].et, max);
		}
		return max;
	}
	private static Activity[] mergeSort(Activity[] acts){
		if(acts == null || acts.length ==0)
			return null;
		
		return merge(acts, 0, acts.length-1);
	}

	private static Activity[] merge(Activity[] acts, int start, int end) {
		if(start > end)
			return null;
		if(start == end){
			Activity[] tmp = new Activity[1];
			tmp[0] = acts[start];
			return tmp;
		}
		
		Activity[] first = merge(acts,start,(start+end)/2);
		Activity[] second = merge(acts,((start+end)/2)+1, end);
		Activity[] third = new Activity[first.length+second.length]; 
		if(first != null && second != null){
			int fst = 0;//first.length;
			int scn = 0;//second.length;
			int trd = 0;
			while(fst < first.length && scn < second.length){
				if(first[fst].et > second[scn].et){
					third[trd++] = second[scn++];
					continue;
				}
				third[trd++] = first[fst++];
			}
			while(fst<first.length){
				third[trd++] = first[fst];
				fst++;
				continue;
			}
			while(scn<second.length){
				third[trd++] = second[scn];
				scn++;
				continue;
			}
		}
		return third;
	}
}
class Activity{
	int st;
	int et;
	public Activity(int s , int e){
		st = s;
		et = e;
	}
	@Override
	public String toString(){
		return st+":"+et;
	}
}
