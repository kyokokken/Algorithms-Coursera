/**
 * (seed = 277853)
 * Give the id[] array that results from the following sequence of 9 union
 * operations on a set of 10 items using the weighted quick-union algorithm from lecture.
 *
 *  0-2 4-6 9-7 0-4 1-9 1-5 9-8 8-4 2-3 

Recall: when joining two trees of equal size, our weighted quick union convention
is to make the root of the second tree point to the root of the first tree.
 */
package week1.unionfind;

public class Question2 {
	WQuickUnionUF wQuickUnionUF;

	public Question2() {
		wQuickUnionUF = new WQuickUnionUF(10);
		wQuickUnionUF.union(0, 2);
		wQuickUnionUF.union(4, 6);
		wQuickUnionUF.union(9, 7);
		wQuickUnionUF.union(0, 4);
		wQuickUnionUF.union(1, 9);
		wQuickUnionUF.union(1, 5);
		wQuickUnionUF.union(9, 8);
		wQuickUnionUF.union(8, 4);
		wQuickUnionUF.union(2, 3);
		wQuickUnionUF.printId();
	}

	public static void main(String args[]) {
		new Question2();
	}
}
