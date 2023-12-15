package com.algo2.week1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distanceTo;
    private int source;

    public BreadthFirstPaths(Graph g, int s) {
        this.source = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        this.marked[s] = true;
        distanceTo[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : g.adj(v)) {
                if(!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distanceTo[w] = distanceTo[v] + 1;
                }
            }
        }
    }

    public int distTo(int v) {
        return this.distanceTo[v];
    }
    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        Deque<Integer> path = new ArrayDeque<>();
        for(int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
