package week1.unionfind;

/**
 * (seed = 416673) Give the id[] array that results from the following sequence
 * of 6 union operations on a set of 10 items using the quick-find algorithm.
 * 
 * 5-9 7-0 5-0 9-3 4-3 1-0
 * 
 * Recall: our quick-find convention for the union operation p-q is to change
 * id[p] (and perhaps some other entries) but not id[q].
 * 
 */

public class Question1 {
//	QuickUnionUF quickUnionUF;
	QuickFindUF quickFindUF;
	
	public Question1() {
		quickFindUF = new QuickFindUF(10);
		quickFindUF.union(5, 9);
		quickFindUF.union(7, 0);
		quickFindUF.union(5, 0);
		quickFindUF.union(9, 3);
		quickFindUF.union(4, 3);
		quickFindUF.union(1, 0);
		
		quickFindUF.printId();
	}
	
	public static void main (String args[])
	{
		new Question1();
	}
}
