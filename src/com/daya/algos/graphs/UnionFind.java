package com.daya.algos.graphs;

public class UnionFind {
	int V , E;
	Edge[] edges;
	class Edge{
		int src;
		int dest;
	}
	
	UnionFind(int v, int e){
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
	
	public int isCyclic(){
		int[] parent = new int[this.V];
		for(int i=0;i<this.V;i++){
			parent[i] = -1;
		}
		for(int j=0;j<this.E;j++){
			int sPnt = this.find(parent, this.edges[j].src);
			int dPnt = this.find(parent, this.edges[j].dest);
			if(sPnt == dPnt)
				return 1;
			this.union(parent, sPnt, dPnt);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(3,3);
		uf.edges[0].src = 0;
		uf.edges[0].dest = 1;
		
		uf.edges[1].src = 1;
		uf.edges[1].dest = 2;
		
		uf.edges[2].src = 2;
		uf.edges[2].dest = 0;
		if(uf.isCyclic() == 1){
			System.out.println("Given Graph is cyclic");
		}else{
			System.out.println("Given Graph is acyclic");
		}
		
	}
}
