package com.algo2.week1;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise18 {
    public int getGirth(Graph g) {
        int girth = Integer.MAX_VALUE;
        for(int v = 0; v < g.getNumberOfVertexes(); v++) {
            int shortestCycle = bfsToGetShortestCycle(g, v);
            girth = Math.min(girth, shortestCycle);
        }
        return girth;
    }

    private int bfsToGetShortestCycle(Graph g, int sourceVertex) {
        int shortestCycle = Integer.MAX_VALUE;
        boolean[] visited = new boolean[g.getNumberOfVertexes()];
        int[] edgeTo = new int[g.getNumberOfVertexes()];
        int[] distanceTo = new int[g.getNumberOfVertexes()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        distanceTo[sourceVertex] = 0;
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for(int neighbor : g.adj(currentVertex)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    edgeTo[neighbor] = currentVertex;
                    distanceTo[neighbor] = distanceTo[currentVertex] + 1;
                    queue.add(neighbor);
                    // We have visited this node neighbor but not through its parent
                    // because in undirected graph, we have trivial connectivity
                    // in both direction.
                } else if(neighbor != edgeTo[currentVertex]) {
                    int cycleLength = distanceTo[currentVertex] + distanceTo[neighbor] + 1;
                    shortestCycle = Math.min(shortestCycle, cycleLength);
                }
            }
        }
        return shortestCycle;
    }
}
