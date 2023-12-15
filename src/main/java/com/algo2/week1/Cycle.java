package com.algo2.week1;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        this.marked = new boolean[G.getNumberOfVertexes()];
        for (int v =0; v < G.getNumberOfVertexes(); v++) {
            if(!marked[v])
                dfs(G, v, v);
        }
    }

    private void dfs(Graph g, int v, int parentOfV) {
        this.marked[v] = true;
        for(int w : g.adj(v)) {
            if(!marked[w])
                dfs(g, w, v);
            // We have visited this node w but not through the parent of V
            // because in undirected graph, we have trivial connectivity
            // in both direction.
            else if (w != parentOfV) {
                hasCycle = true;
            }
        }
    }
}
