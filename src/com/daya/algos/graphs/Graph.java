package com.equinix.algos.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Graph {
	private int V;
	private LinkedList<Integer> adjList[];

	public Graph(int v) {
		V = v;
		adjList = new LinkedList[V];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(int src, int trgt) {
		adjList[src].add(trgt);
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);

	
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		
		
	/*	
		// BINARY TREE WITH 7 NODES
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		
	*/	
		//g.topologicalSort();
		//g.topologicalSort();
		//g.kahnTopologicalSort();
		//g.allTopologicalSort();
		g.DFS(5);System.out.println("");
		g.BFS(5);
/*		
		g.DFS( );
		System.out.println("");
		System.out.println("DFS follows:");
		g.DFSUtil(0);
		System.out.println("");
		System.out.println("Cycle detections:");
		g.isCyclic();
		System.out.println("");
		System.out.println("Out degree:" + g.outDegree(4));
		System.out.println("In degree of 0:" + g.inDegree(5));
*/
	}

	private void topologicalSort() {
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			if(!visited[i]){
				topologicalUtil(i,visited ,stack);
			}
		}
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}

	private void topologicalUtil(int i, boolean[] visited, Stack<Integer> stack) {
		Iterator<Integer> it = adjList[i].iterator();
		visited[i] = true;
		while(it.hasNext()){
			int next = it.next();
			if(!visited[next]){
				topologicalUtil(next,visited,stack);
			}
		}
		stack.push(i);
	}

	private int outDegree(int node) {
		if (node > -1 && node < adjList.length) {
			return adjList[node].size();
		}
		return 0;
	}

	private int inDegree(int node) {
		int count = 0;
		if (node > -1 && node < adjList.length) {
			for (LinkedList<Integer> linkedList : adjList) {
				if(linkedList != null && linkedList.size()>0){
					for (Integer llItem : linkedList) {
						if(llItem == node)
							count++;
					}
				}
			}
		}
		return count;
	}

	private void isCyclic() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] isVisited = new boolean[V];
		for (int i = 0; i < V; i++) {
			LinkedList<Integer> edges = adjList[i];
			if (edges != null && edges.size() > 0) {
				for (Integer edge : edges) {
					if (isVisited[edge] || edge == i) {
						System.out.println("Cycle detected at " + i + ":" + edge);
					}
				}
			}
			isVisited[i] = true;

		}
	}

	private void DFS(){
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			DFSUtil(i,visited ,stack);
		}
	}
	private void DFS(int i){
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		DFSUtil(i,visited ,stack);
	}
	
	private void DFSUtil(int i, boolean[] visited, Stack<Integer> stack) {
		stack.push(i);
		
		while (stack.size() > 0) {
			int node = stack.pop();
			if (!visited[node]) {
				LinkedList<Integer> nodesList = adjList[node];
				visited[node] = true;
				System.out.print(node + " ");
				if (nodesList != null && nodesList.size() > 0) {
					for (Integer childNode : nodesList) {
						stack.push(childNode);
					}
				}
			}
		}

	}
	
	
	
	private void BFSUtil(int i,boolean[] visited,	Queue<Integer> q ) {
		q.add(i);
		//boolean[] visited = new boolean[V];
		while (q.size() != 0) {
			int node = q.poll();
			if (!visited[node]) {
				System.out.print(node + " ");
				visited[node] = true;
				LinkedList<Integer> nodesList = adjList[node];
				if (nodesList != null && nodesList.size() > 0) {
					for (Integer childNode : nodesList) {
						q.add(childNode);
					}
				}
			}
		}

	}
	
	private void BFS() {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new PriorityQueue<Integer>();
		for(int i=0;i<V;i++){
			BFSUtil(i,visited,q);
		}
	}
	
	private void BFS(int i) {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new PriorityQueue<Integer>();
		BFSUtil(i,visited,q);
	}
	
	private void kahnTopologicalSort(){
		int[] inDegree = new int[V];
		Queue<Integer> q = new LinkedList<Integer>();
		Vector<Integer> v = new Vector<Integer>();
		
		for(int i=0;i<V;i++){
			inDegree[i] = inDegree(i);
			if(inDegree[i] == 0){
				q.add(i);
			}
		}
		int cnt = 0;
		while(!q.isEmpty()){
			int node = q.poll();
			v.add(node);
			for (Integer childNode : adjList[node]) {
				if(--inDegree[childNode] == 0){
					q.add(childNode);
				}
			}
			cnt++;
		}
		
		if(cnt != V){
			System.out.println("Given Graph has cycles!");
		}else{
			System.out.println("Given Graph is acyclic!");
			for (Integer integer : v) {
				System.out.println(integer);
			}
			
		}
	}
	
	
	private void allTopologicalSort(){
		boolean[] visited = new boolean[V];
		Vector<Integer> vec = new Vector<Integer>();
		int[] inDegree = new int[V];
		for(int i=0;i<V;i++){
			inDegree[i] = inDegree(i);
		}
		allTopologicalSort(visited,vec,inDegree);
		System.out.println("");
	}

	private void allTopologicalSort(boolean[] visited, Vector<Integer> vec, int[] inDegree) {
		boolean flag = false;
		for(int i=0;i<V;i++){
			if(inDegree[i] <= 0 && !visited[i]){
				for (int node : adjList[i]) {
					--inDegree[node];
				}
				
				vec.add(i);
				visited[i] = true;
				allTopologicalSort(visited, vec, inDegree);
				visited[i] = false;
				vec.remove(vec.size()-1);
				
				for (int node : adjList[i]) {
					++inDegree[node];
				}
				flag = true;				
			}
		}
		
		if(!flag){
			for (int i : vec) {
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
		
	}
	
	
	
}



























