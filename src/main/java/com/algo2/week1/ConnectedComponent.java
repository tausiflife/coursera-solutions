package com.algo2.week1;

public class ConnectedComponent {
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(Graph g) {
        marked = new boolean[g.getNumberOfVertexes()];
        id = new int[g.getNumberOfVertexes()];
        for(int v =0; v< g.getNumberOfVertexes(); v++) {
            if(!marked[v]) {
                dfs(g, v);
                this.count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        this.marked[v] =true;
        this.id[v] = this.count;
        for (int w : g.adj(v)) {
            if(!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return this.id[v];
    }

    public boolean connected(int v, int w) {
        return this.id[v] == this.id[w];
    }
}
