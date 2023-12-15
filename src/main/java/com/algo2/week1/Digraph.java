package com.algo2.week1;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int v) {
        this.V = v;
        adj = (ArrayList<Integer>[])new ArrayList[v];
        for (int i =0; i<v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * Edge from v to w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v =0; v < V; v++) {
            for (int w : adj[v])
                R.addEdge(w, v);
        }
        return R;
    }
}
