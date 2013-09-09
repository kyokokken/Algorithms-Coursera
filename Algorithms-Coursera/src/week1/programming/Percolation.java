package week1.programming;

public class Percolation {
	
	private int N;
	private boolean[][] open;
	private boolean[][] full;
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N) 
	{
		this.N = N;
		open = new boolean[N][N];
		full = new boolean[N][N];
	}
	
	// open site (row i, column j) if it is not already
	public void open(int i, int j)
	{
		if (!open[i-1][j-1])
			open[i-1][j-1] = true;
	}
	
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j)
	{
		return open[i-1][j-1];
	}
	
	// is site (row i, column j) full?
	public boolean isFull(int i, int j)
	{
		return full[i-1][j-1];
	}
	
	// does the system percolate?
	public boolean percolates()
	{
		return false;
	}
	
}
