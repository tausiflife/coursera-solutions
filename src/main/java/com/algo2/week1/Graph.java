package com.algo2.week1;

import lombok.Getter;

import java.util.*;

public class Graph {
    @Getter
    private final int V;
    private List<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.adj = (List<Integer>[])new ArrayList[v];
        for(int i= 0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public int getNumberOfVertexes() {
        return this.V;
    }

    /**
     * Returns a copy of the graph.
     * @return @see com.algo2.week1.Graph
     */
    public Graph copy() {
        Graph copy = new Graph(V);
        for (int i = 0; i < adj.length; i++) {
            List<Integer> srcAdj = adj[i];
            List<Integer> destAdj = new ArrayList<>();
            Collections.copy(destAdj, srcAdj);
            copy.adj[i] = destAdj;
        }
        return copy;
    }

    /**
     *
     * @param v
     * @param w
     * @return true if the graph has an edge v-w, false otherwise.
     */
    public boolean hasEdge(int v, int w) {
        List<Integer> edges = adj[v];
        return edges.stream().anyMatch( e -> e == w);
    }

    public void addEdgeWithoutSelfLoop(int v, int w) throws SelfLoopException {
        if(v == w)
            throw new SelfLoopException();
        addEdge(v, w);
    }
}
