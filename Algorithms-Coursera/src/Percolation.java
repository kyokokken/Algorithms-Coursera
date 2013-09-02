/**
 * By convention, the indices i and j are integers between 1 and N, where (1, 1)
 * is the upper-left site: Throw a java.lang.IndexOutOfBoundsException if either
 * i or j is outside this range. The constructor should take time proportional
 * to N^2; all methods should take constant time plus a constant number of calls
 * to the union-find methods union(), find(), connected(), and count().
 */

public class Percolation {
	boolean[][] open;
	boolean[][] full;
	int N;
	private WeightedQuickUnionUF weightedQuickUnionUF;
	Interval1D interval1D;

	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		open = new boolean[N][N];
		full = new boolean[N][N];

		this.N = N;
		weightedQuickUnionUF = new WeightedQuickUnionUF(N * N);
		// interval1D = new Interval1D(1, N * N);
	}

	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		open[i - 1][j - 1] = true;
		if (j > 1 && isOpen(i, j - 1)) // Se non siamo nel bordo
		{
			weightedQuickUnionUF.union(xyTo1D(i - 1, j - 1),
					xyTo1D(i - 1, (j - 1) - 1));
		}
		if (j < N && isOpen(i, j + 1)) {
			weightedQuickUnionUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 1, j));
		}
		if (i > 1 && isOpen(i - 1, j)) {
			weightedQuickUnionUF.union(xyTo1D(i - 1, j - 1),
					xyTo1D((i - 1) - 1, j - 1));
		}
		if (i < N && isOpen(i + 1, j)) {
			weightedQuickUnionUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i, j - 1));
		}
		
		for (int ii = 0; ii < N; ii++) {
			for (int jj = 0; jj < N; jj++) {
				if (open[ii][jj] && !full[ii][jj]) {
					if (ii == 0 || (ii > 0 && full[ii - 1][jj])
							|| (ii < N - 1 && full[ii + 1][jj])
							|| (jj > 0 && full[ii][jj - 1])
							|| (jj < N - 1 && full[ii][jj + 1])) {
						full[ii][jj] = true;
					}
				}
			}
		}
	}

	private int xyTo1D(int i, int j) {
		return ((i * N) + (j % N));
	}

	// is site (row i, column j) open)
	public boolean isOpen(int i, int j) {
		return open[i - 1][j - 1];
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		return full[i - 1][j - 1];
	}

	// does the system percolate?
	public boolean percolates() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (open[i][j] && !full[i][j]) {
//					if (i == 0 || (i > 0 && full[i - 1][j])
//							|| (i < N - 1 && full[i + 1][j])
//							|| (j > 0 && full[i][j - 1])
//							|| (j < N - 1 && full[i][j + 1])) {
//						full[i][j] = true;
//					}
//				}
//			}
//		}

		for (int i = 0; i < N; i++)
		{
			if (full[N-1][i])
				return true;
		}
//		for (int topSite = 0; topSite < N; topSite++) {
//			for (int bottomSite = (N * N) - N; bottomSite < N * N; bottomSite++) {
//				if (weightedQuickUnionUF.connected(topSite, bottomSite))
//					return true;
//			}
//		}
		return false;
	}

	public static void main(String args[]) {
		int N = 20;
		Percolation p = new Percolation(N);
		while (!p.percolates()) {
			int randomRow = (int) (StdRandom.uniform() * N) + 1;
			int randomColumn = (int) (StdRandom.uniform() * N) + 1;
			int timeout = N * N;
			while (p.isOpen(randomRow, randomColumn) && timeout > 0) {
				if (randomColumn >= N) {
					randomColumn = 1;
					if (randomRow >= N) {
						randomRow = 1;
					} else
						randomRow++;
				} else
					randomColumn++;
				timeout--;
			}
			if (timeout < 0) // all sites were open...
			{
				break;
			} else {
				p.open(randomRow, randomColumn);
				// System.out.println(randomRow + ", " + randomColumn);
			}
		}
	}
}
