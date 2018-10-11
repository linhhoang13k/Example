package com.iub.coding.practice.CodeName47;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
 * HackerRank Problem
 * 
 * URL: https://www.hackerrank.com/challenges/components-in-graph
 */

public class ComponentsInGraph {

	public static void main(String[] args) {

		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

		Map<Integer, HashSet<Integer>> forward = new HashMap<Integer, HashSet<Integer>>();
		Map<Integer, HashSet<Integer>> backward = new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> visited = new HashSet<Integer>();

		Scanner sr = new Scanner(System.in);

		int n = sr.nextInt();
		Map<Integer, HashSet<Integer>> result = new HashMap<Integer, HashSet<Integer>>();

		int num1 = 0, num2 = 0, index = 0;

		for (int i = 0; i < n; i++) {

			num1 = sr.nextInt();
			num2 = sr.nextInt();

			if (forward.containsKey(num1))
				forward.get(num1).add(num2);
			else {

				HashSet<Integer> tempSet = new HashSet<Integer>();
				tempSet.add(num2);
				forward.put(num1, tempSet);
			}

			if (backward.containsKey(num2))
				backward.get(num2).add(num1);
			else {
				HashSet<Integer> tempSet = new HashSet<Integer>();
				tempSet.add(num1);
				backward.put(num2, tempSet);
			}

		}

		Iterator it = forward.entrySet().iterator();

		Entry<Integer, HashSet<Integer>> entry = null;

		int min = 2 * n + 1, max = 0, count = 0;

		while (it.hasNext()) {

			entry = (Entry<Integer, HashSet<Integer>>) it.next();

			if (!visited.contains(entry.getKey())) {

				count = getConnectedGraphNodeCount(forward, backward, entry.getKey(), visited);

				if (min > count)
					min = count;
				if (max < count)
					max = count;

			}

		}
		System.out.println(min + " " + max);

	}

	public static int getConnectedGraphNodeCount(Map<Integer, HashSet<Integer>> forward,
			Map<Integer, HashSet<Integer>> backward, int element, HashSet<Integer> visited) {

		Queue<Integer> q = new LinkedList<Integer>();
		int num, count = 0, connectedNode = 0;
		boolean isSource = true;
		Set<Integer> nodeCount = new HashSet<Integer>();
		Iterator<Integer> it = null;

		q.add(element);
		if (!visited.contains(element)) {

			visited.add(element);
		}

		while (!q.isEmpty()) {

			num = q.poll();
			count++;

			if (forward.containsKey(num)) {

				it = forward.get(num).iterator();

			} else {

				it = backward.get(num).iterator();

			}

			while (it.hasNext()) {

				connectedNode = it.next();

				if (!visited.contains(connectedNode)) {
					q.add(connectedNode);
					visited.add(connectedNode);
				}
			}

		}
		return count;
	}
}
