package week1.unionfind;

public class WQuickUnionUF {
	private int[] id;
	private int[] sz;

	public WQuickUnionUF(int n) {
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 0;
		}

	}

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		printId();
	}

	public void printId() {
		for (int i = 0; i < id.length; i++)
			System.out.print(id[i] + " ");
		System.out.println();
	}
}
