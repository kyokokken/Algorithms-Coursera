package week1.unionfind;

public class QuickUnionUF {
	private int[] id;
	
	public QuickUnionUF(int n)
	{
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}
	
	private int root(int i)
	{
		while (i != id[i])
			i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
		printId();
	}

	public void printId() {
		for (int i = 0; i < id.length; i++)
			System.out.print(id[i] + " ");
		System.out.println();
		
	}

	public void setId(int[] is) {
		id = is;
		
	}

	public int[] getId() {
		return id;
	}
	
	public int getDepth(int i)
	{
		int depth = 0;
		while (i != id[i])
		{
			i = id[i];
			depth++;
		}
		return depth;		
	}
}
