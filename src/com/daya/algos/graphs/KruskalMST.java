package com.equinix.algos.graphs;

import java.util.Arrays;

public class KruskalMST {
	int V , E;
	Edge[] edges;
	
	class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		
		@Override
		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
		
	}
	
	KruskalMST(int v, int e){
		V = v; 
		E = e;
		edges = new Edge[E];
		for(int i=0;i<E;i++){
			edges[i] = new Edge();
		}
	}
	
	public int find(int[] parent,int i){
		if(parent[i] == -1)
			return i;
		return find(parent,parent[i]);
	}
	
	public void union(int[] parent, int x, int y){
		int xPnt = find(parent, x);
		int yPnt = find(parent, y);
		parent[xPnt] = yPnt;
	}
	
	public int isCyclic(Edge[] edges, int length){
		int[] parent = new int[V];
		for(int i=0;i<V;i++){
			parent[i] = -1;
		}
		for(int j=0;j<length;j++){
			int sPnt = this.find(parent, edges[j].src);
			int dPnt = this.find(parent, edges[j].dest);
			if(sPnt == dPnt)
				return 1;
			this.union(parent, sPnt, dPnt);
		}
		return 0;
	}
	
	public Edge[] kruskalMST(){
		Edge[] resultEdges = new Edge[V-1];
		// Sort all the edges in non-decreasing order. 
		Arrays.sort(edges);
		int i = 0;
		int j = 0;
		while(i<V-1 && j<E){
			resultEdges[i] = edges[j];
			if(isCyclic(resultEdges,i+1) == 1){
				// Resultant Graphic is cyclic. Remove the current Edge from the subset.
				resultEdges[i] = null;
				j++; 
				continue;
			}else{
				// Resultant Graphic is acyclic. Can include the current edge in the subset.
				j++;i++; 
				
				
				continue;
			}	
		}
		
		return resultEdges;
	}
	
	
	
	

	public static void main(String[] args) {
		
		
		
		
		
		
		
		/*
		KruskalMST uf = new KruskalMST(3,3);
		uf.edges[0].src = 0;
		uf.edges[0].dest = 1;
		uf.edges[0].weight = 10;
		
		uf.edges[1].src = 1;
		uf.edges[1].dest = 2;
		uf.edges[1].weight = 2;
		
		
		uf.edges[2].src = 2;
		uf.edges[2].dest = 0;
		uf.edges[2].weight = 5;
		*/
		
		KruskalMST uf = new KruskalMST(9,14);
		
		uf.edges[0].src = 0;
		uf.edges[0].dest = 1;
		uf.edges[0].weight = 4;
		
		uf.edges[1].src = 0;
		uf.edges[1].dest = 7;
		uf.edges[1].weight = 8;
		
		uf.edges[10].src = 1;
		uf.edges[10].dest = 2;
		uf.edges[10].weight = 8;
		
		uf.edges[2].src = 1;
		uf.edges[2].dest = 7;
		uf.edges[2].weight = 11;
		
		
		uf.edges[3].src = 2;
		uf.edges[3].dest = 3;
		uf.edges[3].weight = 7;
		
		uf.edges[4].src = 2;
		uf.edges[4].dest = 5;
		uf.edges[4].weight = 4;
		
		uf.edges[5].src = 2;
		uf.edges[5].dest = 8;
		uf.edges[5].weight = 2;
		
		uf.edges[6].src = 3;
		uf.edges[6].dest = 4;
		uf.edges[6].weight = 9;
		
		uf.edges[7].src = 3;
		uf.edges[7].dest = 5;
		uf.edges[7].weight = 14;
		
		uf.edges[8].src = 4;
		uf.edges[8].dest = 5;
		uf.edges[8].weight = 10;
		
		uf.edges[9].src = 5;
		uf.edges[9].dest = 6;
		uf.edges[9].weight = 2;
		
		uf.edges[11].src = 6;
		uf.edges[11].dest = 7;
		uf.edges[11].weight = 1;
		
		uf.edges[12].src = 6;
		uf.edges[12].dest = 8;
		uf.edges[12].weight = 6;
		
		uf.edges[13].src = 7;
		uf.edges[13].dest = 8;
		uf.edges[13].weight = 7;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(uf.isCyclic(uf.edges,uf.edges.length) == 1){
			System.out.println("Given Graph is cyclic");
		}else{
			System.out.println("Given Graph is acyclic");
		}
		
		Edge[] res = uf.kruskalMST();
		if(res != null && res.length > 0 ){
			for (Edge edge : res) {
				System.out.println(edge.src+"---("+edge.weight+")-->"+edge.dest);
			}
		}
		
		
	}
}
