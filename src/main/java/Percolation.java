import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private final int virtualTopIndex;
    private final int virtualBottomIndex;
    private boolean[][] grid;
    private int numberOfOpenSites;
    private final WeightedQuickUnionUF quickUnionUF;
    private final int length;
    /**
     * Creates n-by-n grid, with all sites initially blocked.
     * @param n
     */
    public Percolation(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Dimension should be positive");
        this.virtualTopIndex = 0;
        this.virtualBottomIndex = n * n + 1;
        this.grid = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                this.grid[i][j] = false;
        quickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        this.length = n;
    }

    private int convertRowColToIndex(int row, int col) {
        return ((row - 1) * length) + col;
    }

    /**
     * Open the site(row, col), if not open already.
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col))
            return;
        this.grid[row - 1][col - 1] = true;
        this.numberOfOpenSites++;
        int index1D = convertRowColToIndex(row, col);
        if (row == 1)
            quickUnionUF.union(index1D, virtualTopIndex);
        if (row == this.length)
            quickUnionUF.union(index1D, virtualBottomIndex);
        // right neighbour row,col+1
        if (col < this.length && isOpen(row, col + 1))
            quickUnionUF.union(convertRowColToIndex(row, col + 1), index1D);
        // left neighbour row,col-1
        if (col > 1 && isOpen(row, col - 1))
            quickUnionUF.union(convertRowColToIndex(row, col - 1), index1D);
        // top neighbour
        if (row > 1 && isOpen(row - 1, col))
            quickUnionUF.union(convertRowColToIndex(row-1, col), index1D);
        // bottom neighbour
        if (row < this.length && isOpen(row + 1, col))
            quickUnionUF.union(convertRowColToIndex(row + 1, col), index1D);

    }

    /**
     * is the site(row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return this.grid[row - 1][col - 1];
    }

    /**
     * is the site(row,col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
        return quickUnionUF.find(convertRowColToIndex(row, col)) == quickUnionUF.find(this.virtualTopIndex);
    }

    /**
     * Returns the number of open sites.
     * @return
     */
    public int numberOfOpenSites() {
        return this.numberOfOpenSites;
    }

    /**
     * Does the system percolates?
     * @return
     */
    public boolean percolates() {
        return quickUnionUF.find(this.virtualBottomIndex) == quickUnionUF.find(this.virtualTopIndex);
    }

    /**
     * Validates if the row and column are range bound or not.
     * They should be between 1 and N
     * @param row
     * @param col
     */
    private void validate(int row, int col) {
        if (row < 1 || row > this.length || col < 1 || col > this.length)
            throw new IllegalArgumentException("Index out of bound");

    }

    public static void main(String[] args) {
    }
}
