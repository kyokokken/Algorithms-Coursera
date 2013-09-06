public class PercolationStats {

	private double[] means;
	private int T;
	private double mean = 0.0;
	private double stddev = 0.0;

	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException();
		}
		means = new double[T];
		this.T = T;
		
		
		for (int i = 0; i < T; i++) {
			Percolation p = new Percolation(N);
			int openSites = 0;
			while (!p.percolates()) {
				int randomRow = (int) (StdRandom.random() * N) + 1;
				int randomColumn = (int) (StdRandom.random() * N) + 1;
				while (p.isOpen(randomRow, randomColumn)) {
					randomRow = (int) (StdRandom.random() * N) + 1;
					randomColumn = (int) (StdRandom.random() * N) + 1;
				}
				p.open(randomRow, randomColumn);
				openSites++;
			}
			means[i] = (double) openSites / (double) (N * N);
//			System.out.println(i+1 + " / " + T);
		}
		
	}

	// sample mean of percolation threshold
	public double mean() {
		if (mean == 0.0) {
			for (int i = 0; i < T; i++)
				mean += means[i];
			mean /= T;
		}
		return mean;
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		if (T <= 1) {
			return Double.NaN;
		}
		if (stddev == 0.0) {
			for (int i = 0; i < T; i++) {
				stddev += (((double) (means[i] - mean()))
						* ((double) (means[i] - mean())));
			}
			stddev /= (T - 1);
			stddev = Math.sqrt(stddev);
		}
		return stddev;
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return mean() - (1.96 * stddev() / Math.sqrt(T));
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return mean() + (1.96 * stddev() / Math.sqrt(T));
	}

	// test client
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);

		PercolationStats pStats = new PercolationStats(N, T);
		StdOut.print("mean: " + pStats.mean() + "\n");
		StdOut.print("stddev: " + pStats.stddev() + "\n");
		StdOut.print("95% confidence interval: " + pStats.confidenceLo() + " "
				+ pStats.confidenceHi() + "\n");

	}
}
