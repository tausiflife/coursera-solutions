import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int trials;
    private final double[] threshold;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("Invalid arguments");
        this.trials = trials;
        this.threshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                percolation.open(row, col);
            }
            this.threshold[i] = (double) percolation.numberOfOpenSites()/(n * n);
        }
    }

    public double mean() {
        return StdStats.mean(this.threshold);
    }

    public double stddev() {
        return StdStats.stddev(this.threshold);
    }

    public double confidenceLo() {
        return StdStats.mean(this.threshold) - ((CONFIDENCE_95 * StdStats.stddev(this.threshold)) / Math.sqrt(this.trials));
    }

    public double confidenceHi() {
        return StdStats.mean(this.threshold) + ((CONFIDENCE_95 * StdStats.stddev(this.threshold)) / Math.sqrt(this.trials));
    }

    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("Invalid number of arguments");
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        if (n <= 0 || t <= 0)
            throw new IllegalArgumentException("Invalid arguments");
        PercolationStats stats = new PercolationStats(n, t);
        System.out.println("mean\t="+ stats.mean());
        System.out.println("stddev\t="+ stats.stddev());
        System.out.println(String.format("95%% confidence interval = [%f, %f]", stats.confidenceLo(), stats.confidenceHi()));
    }
}
