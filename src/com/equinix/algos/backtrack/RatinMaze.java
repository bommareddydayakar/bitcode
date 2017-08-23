package com.equinix.algos.backtrack;

public class RatinMaze {
	public static void main(String[] args) {
		 RatinMaze rat = new RatinMaze();
	        int maze[][] = 
	        		{
	        			{1, 1, 1, 1,1},
	        			{0, 1, 1, 1,1},
			            {1, 1, 0, 0,1},
			            {1, 0, 1, 1,1},
			            {1, 1, 1, 0,1}
			            
			        };
	        rat.solveMaze(maze);
	}

	private void solveMaze(int[][] maze) {
		if(maze == null || maze.length ==0)
			System.out.println("Maze cannt be solved as it is empty!");
		int sol[][] = new int[maze.length][maze[0].length];
		if(solveMazeUtil(maze, sol, 0, 0))
			printSol(sol);
		else
			System.out.println("Maze could not be solved");
	}

	private boolean solveMazeUtil(int[][] maze, int[][] sol, int x, int y) {
		if(x == maze.length-1 && y == maze[0].length){
			return true;
		}
		if(isSafeToUpdate(maze,sol,x,y)){
			sol[x][y] = 1;
			if(solveMazeUtil(maze, sol, x+1, y))
				return true;
			
			if(solveMazeUtil(maze, sol, x, y+1))
				return true;
			
			if(solveMazeUtil(maze, sol, x-1, y))
				return true;
			
			if(solveMazeUtil(maze, sol, x, y-1))
				return true;
			
			
			
			sol[x][y] = 0;
		}
		return false;
	}

	private boolean isSafeToUpdate(int[][] maze, int[][] sol, int x, int y) {
		if(x <0 || x >= sol.length || y<0 || y >= sol[x].length )
			return false;
		if(maze[x][y] != 1 || sol[x][y] == 1)
			return false;
			
		return true;
	}

	private void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
