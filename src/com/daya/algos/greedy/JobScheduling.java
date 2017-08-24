package com.daya.algos.greedy;

public class JobScheduling {
	public static void main(String[] args) {
		int[][] arr = { 
				{ 9, 15 },
				{ 2, 2 },
				{ 5, 18 },
				{ 7, 1 },
				{ 4, 25 },
				{ 2, 20 },
				{ 5, 8 },
				{ 7, 10 },
				{ 4, 12 },
				{ 3, 5 }
			};
		
		Job[] jobs = new Job[arr.length];
		for (int i = 0; i < arr.length; i++) {
			Job job = new Job(arr[i][0],arr[i][1]);
			jobs[i] = job;
		}
		
		jobs = mergeSort(jobs);
		for (Job job : jobs) {
			System.out.print(job.deadLine+":"+job.profit+"<<-->>");
		}
		System.out.print("*********************************");
		System.out.println(findMaxProfit(jobs));
		
	}
	
	private static int findMaxProfit(Job[] jobs) {
		if(jobs == null || jobs.length ==0)
			return 0;
		else if(jobs.length == 1)
			return jobs[0].profit;
		
		int maxDeadLine = getMaxDeadLine(jobs);
		int profit = 0;
		if(maxDeadLine > 0){
			Job[] scheduler = new Job[maxDeadLine];
			
			for (int i = 0; i < jobs.length; i++) {
				Job curJob = jobs[i];
				int j=curJob.deadLine-1;
				while(j > -1){
					if(scheduler[j] == null){
						scheduler[j] = curJob;
						break;
					}
					j--;
				}
			}
			for (Job job : scheduler) {
				if(job != null){
					System.out.println(job);
					profit += job.profit;
				}
			}
		}
		return profit;
	}

	private static int getMaxDeadLine(Job[] jobs) {
		if(jobs == null || jobs.length ==0)
			return 0;
		int max = 0;
		for (int i = 0; i < jobs.length; i++) {
			max = Math.max(jobs[i].deadLine, max);
		}
		return max;
	}

	private static Job[] mergeSort(Job[] jobs){
		if(jobs == null || jobs.length ==0)
			return null;
		
		return merge(jobs, 0, jobs.length-1);
	}

	private static Job[] merge(Job[] jobs, int start, int end) {
		if(start > end)
			return null;
		if(start == end){
			Job[] tmp = new Job[1];
			tmp[0] = jobs[start];
			return tmp;
		}
		
		Job[] first = merge(jobs,start,(start+end)/2);
		Job[] second = merge(jobs,((start+end)/2)+1, end);
		Job[] third = new Job[first.length+second.length]; 
		if(first != null && second != null){
			int fst = 0;//first.length;
			int scn = 0;//second.length;
			int trd = 0;
			while(fst < first.length && scn < second.length){
				if(first[fst].profit < second[scn].profit){
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

class Job {
	int deadLine;
	int profit;

	Job(int dl, int pf) {
		deadLine = dl;
		profit = pf;
	}
	@Override
	public String toString() {
		return deadLine+":"+profit;
				
	}
}
