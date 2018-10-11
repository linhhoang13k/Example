package com.ctci.chapter4;

import com.ctci.library.Graph;

import java.util.*;

/**
 * Created by zambro on 4/23/17.
 *
 * Given a directed graph, find if there is a path between two nodes
 */
public class GraphPathFinder extends Graph {

    public boolean hasPathDFS(int sourceId, int destinationId) {
        Node source = nodeList.get(sourceId);
        Node destination = nodeList.get(destinationId);
        return hasPathDFS(source,destination,new ArrayList<>());
    }

    private boolean hasPathDFS(Node source, Node destination, List<Integer> vistied) {
        if(vistied.contains(source.id)) {
            return false;
        }

        vistied.add(source.id);
        if(source == destination)
            return true;

        for(Node child:source.adjacents)
            if(hasPathDFS(child, destination, vistied))
                return true;

        return  false;
    }

    public boolean hasPathBFS(int sourceId, int destinationId) {
        Node source = nodeList.get(sourceId);
        Node destination = nodeList.get(destinationId);
        return hasPathBFS(source, destination);
    }

    private boolean hasPathBFS(Node source, Node destination) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited.contains(node.id))
                continue;
            visited.add(node.id);
            if(node == destination)
                return true;

            for(Node child:node.adjacents)
                queue.add(child);
        }

        return false;
    }
    public static void main(String[] args) {
        GraphPathFinder g = new GraphPathFinder();
        g=(GraphPathFinder) GraphPathFinder.createCTCTGraph1(g);
        g.printDFS(0);
        System.out.println("\nPath between 0 and 5? "+g.hasPathDFS(0,5));
        System.out.println("Path between 2 and 4? "+g.hasPathDFS(2,4));
        System.out.println("Path between 0 and 5? "+g.hasPathDFS(0,5));
        System.out.println("Path between 5 and 3? "+g.hasPathDFS(5,3));
        System.out.println("Path between 3 and 5? "+g.hasPathDFS(3,5));

        System.out.println("\nPath between 0 and 5? "+g.hasPathBFS(0,5));
        System.out.println("Path between 2 and 4? "+g.hasPathBFS(2,4));
        System.out.println("Path between 0 and 5? "+g.hasPathBFS(0,5));
        System.out.println("Path between 5 and 3? "+g.hasPathBFS(5,3));
        System.out.println("Path between 3 and 5? "+g.hasPathBFS(3,5));
    }
}
