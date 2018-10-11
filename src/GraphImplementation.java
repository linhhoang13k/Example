package com.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplementation {
	private int [] v;
	private int [][] edge;
	public GraphImplementation(int n,int m) {
		this.v = new int[n];
		this.edge = new int [m][2];
	}
	
	
	public int[] getV() {
		return v;
	}


	public void setV(int[] v) {
		this.v = v;
	}


	public int[][] getEdge() {
		return edge;
	}


	public void setEdge(int[][] edge) {
		this.edge = edge;
	}

	
	public boolean [][] graphRepresentations(){
		int n = this.v.length;
		boolean [][] res = new boolean[n][n];
		for(int i=0;i<this.edge.length;i++)
		{			
			int firstVerice = this.edge[i][0];
			int secondVertice = this.edge[i][1];
			res[firstVerice][secondVertice] = res[secondVertice][firstVerice] = true;
		}
		return res;
	}
	
	public List<List<Integer>> runDFS() {
		boolean [] isVisited = new boolean[this.v.length];
		boolean [][] graph = graphRepresentations();
		List<List<Integer>> connectedComp = new ArrayList<>();
		for(int i=0;i<this.v.length;i++) {
			int n = this.v[i];
			if(!isVisited[n]) {
				isVisited[n] = true;
				List<Integer> list = new ArrayList<>();
				list.add(n);
				graphDFS(n, isVisited, list, graph);
				connectedComp.add(list);
			}
		}
		return connectedComp;
	}
	
	public void graphDFS(int n, boolean[] isVisited, List<Integer> connectedVertices,boolean [][] graph){
		for(int i=0;i<this.v.length;i++) {
			int vertex = this.v[i];
			if(!isVisited[vertex]) {
				if(graph[n][vertex]) {
					isVisited[vertex] = true;
					connectedVertices.add(vertex);
					graphDFS(vertex, isVisited, connectedVertices, graph);
				}
			}
			
		}
	}
}
