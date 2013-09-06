/**
 * By convention, the indices i and j are integers between 1 and N, where (1, 1)
 * is the upper-left site: Throw a java.lang.IndexOutOfBoundsException if either
 * i or j is outside this range. The constructor should take time proportional
 * to N^2; all methods should take constant time plus a constant number of calls
 * to the union-find methods union(), find(), connected(), and count().
 */

public class Percolation {
	private boolean[][] open;
	private int N;
	private WeightedQuickUnionUF openUF;
	private WeightedQuickUnionUF percUF;

	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		open = new boolean[N][N];
		this.N = N;
		openUF = new WeightedQuickUnionUF(N * N + 2);
		percUF = new WeightedQuickUnionUF(N * N + 2);
	}

	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		// Exceptions
		if (i < 1 || j < 1 || i > N || j > N)
			throw new IndexOutOfBoundsException();
		if (isOpen(i, j))
			return;
		
		open[i - 1][j - 1] = true;

		if (i == 1)
		{
			openUF.union(0, xyTo1D(i-1, j-1));
			percUF.union(0, xyTo1D(i-1, j-1));
		}
		if (i == N)
		{
			percUF.union(xyTo1D(i-1, j-1), (N*N)+1);
		}
		
		if (j > 1 && isOpen(i, j - 1)) // Se non siamo nel bordo
		{
			openUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 1, j - 2));
			percUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 1, j - 2));
		}
		if (j < N && isOpen(i, j + 1)) {
			openUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 1, j));
			percUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 1, j));
		}
		if (i > 1 && isOpen(i - 1, j)) {
			openUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 2, j - 1));
			percUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i - 2, j - 1));
		}
		if (i < N && isOpen(i + 1, j)) {
			openUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i, j - 1));
			percUF.union(xyTo1D(i - 1, j - 1), xyTo1D(i, j - 1));
		}
		


	}

	private int xyTo1D(int i, int j) {
		return ((i * N) + (j % N) + 1);
	}

	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		// Exceptions
		if (i < 1 || j < 1 || i > N || j > N)
			throw new IndexOutOfBoundsException();
		return open[i - 1][j - 1];
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		// Exceptions
		if (i < 1 || j < 1 || i > N || j > N)
			throw new IndexOutOfBoundsException();

		return openUF.connected(xyTo1D(i-1, j-1), 0);
	}

	// does the system percolate?
	public boolean percolates() {
		return percUF.connected(0, N*N+1);
	}
}
