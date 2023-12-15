package com.algo2.week1;

/**
 * Can the vertices of the graph be assigned two colors in
 * such a way that no edge connects vertices of the same color.
 * Is this graph bipartite?
 */
public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;
    public Bipartite(Graph g) {
        this.marked = new boolean[g.getNumberOfVertexes()];
        this.color = new boolean[g.getNumberOfVertexes()];
        for(int v = 0; v< g.getNumberOfVertexes(); v++) {
            if(!marked[v])
                dfs(g, v);
        }
    }

    private void dfs(Graph g, int v) {
        this.marked[v] = true;
        for(int w: g.adj(v)) {
            if(!this.marked[w]) {
                dfs(g, w);
                this.color[w] = !this.color[v];
            }
            else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }
}
