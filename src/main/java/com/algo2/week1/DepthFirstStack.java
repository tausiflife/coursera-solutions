package com.algo2.week1;

import java.util.ArrayDeque;
import java.util.Stack;

public class DepthFirstStack {
    private boolean[] marked;

    private int source;
    public DepthFirstStack(Graph g, int source) {
        this.source = source;
        this.marked = new boolean[g.getNumberOfVertexes()];
        dfs(g, source);
    }

    private void dfs(Graph g, int source) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.addFirst(source);
        this.marked[source] = true;
        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            for (int adj : g.adj(vertex)) {
                if (!this.marked[adj]) {
                    stack.addLast(adj);
                    this.marked[adj] = true;
                }
            }
        }
    }
}
