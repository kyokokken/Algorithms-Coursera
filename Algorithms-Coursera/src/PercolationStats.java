public class PercolationStats {

	double mean;

	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < T; i++) {
			Percolation p = new Percolation(N);
			int openSites = 0;
			while (!p.percolates()) {
				int randomRow = (int) (StdRandom.uniform() * N) + 1;
				int randomColumn = (int) (StdRandom.uniform() * N) + 1;
				while (p.isOpen(randomRow, randomColumn)) {
					if (randomColumn >= N) {
						randomColumn = 1;
						if (randomRow >= N) {
							randomRow = 1;
						} else
							randomRow++;
					} else
						randomColumn++;
				}
				p.open(randomRow, randomColumn);
				openSites++;
				// System.out.println(randomRow + ", " + randomColumn);
			}
//			System.out.println(mean);
			mean += (double)openSites / (N * N);
		}
		

		mean /= T;

	}

	// sample mean of percolation threshold
	public double mean() {
		return mean;
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return 0.0;
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return 0.0;
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return 0.0;
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
