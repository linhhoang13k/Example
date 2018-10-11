package com.interview.goDaddy;

import java.util.*;

import com.interview.graph.GraphImplementation;
public class GoDaddyBot {
	private GraphImplementation graph; 
	public String[][] domainForwarding(String[][] redirects){
		
		Set<String> set = new HashSet<>();
		for(int i=0;i<redirects.length;i++)
			for(int j=0;j<redirects[i].length;j++) {
				set.add(redirects[i][j]);
			}
		List<String> domainList = new ArrayList<>(set);
		Collections.sort(domainList);
		Map<String,Integer> mapDomain = new HashMap<>();
		for(int i=0;i<domainList.size();i++) {
			mapDomain.put(domainList.get(i),i);
		}
		int [] v = new int [domainList.size()];
		for(int i = 0;i<v.length;i++) {
			v[i] = i;
		}
		int [][] edges = new int[redirects.length][2];
		for(int i=0;i<edges.length;i++) {
			for(int j=0;j<2;j++) {
				edges[i][j] = mapDomain.get(redirects[i][j]);
			}
		}
		List<String> key = new ArrayList<>(mapDomain.keySet());
		Collections.sort(key);
		graph = new GraphImplementation(v.length, edges.length);
		graph.setEdge(edges);
		graph.setV(v);
		List<List<Integer>> list = graph.runDFS();
		int [][] arr = convertListToMatrix(list);
		String [][] output = new String [arr.length][];
		for(int i=0;i<arr.length;i++) {
			int n = arr[i].length;
			output[i] = new String [n];
			for(int j=0;j<n;j++) {
				output[i][j] = key.get(arr[i][j]);
			}
		}
		return output;
	}
	public int [][] convertListToMatrix(List<List<Integer>> list){
		int size = list.size();
		int [][] res = new int[size][];
		for(int i=0;i<size;i++) {
			List<Integer> l = list.get(i);
			int length = l.size();
			res[i] = new int [length];
			for(int j=0;j<length;j++) {
				res[i][j] = l.get(j);
			}
		}
		return res;
	}
}
