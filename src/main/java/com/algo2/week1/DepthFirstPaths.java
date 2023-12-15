package com.algo2.week1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class DepthFirstPaths implements Paths{
    private boolean[] marked;
    // If v is connected to s, edge[v]= previous vertex on path from s to v
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph G, int s) {
        this.source = s;
        this.marked = new boolean[G.getNumberOfVertexes()];
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for(int w : g.adj(v)) {
            if(!marked[w]) {
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
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
