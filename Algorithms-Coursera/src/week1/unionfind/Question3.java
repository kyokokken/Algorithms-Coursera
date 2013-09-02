/**
(seed = 757350)
Which of the following id[] array(s) could be the result of running the weighted quick union
algorithm on a set of 10 items?
2 8 2 0 3 2 2 2 2 0
3 9 9 9 2 2 9 9 4 8
9 3 9 3 3 9 8 9 9 3
0 3 6 3 4 4 6 7 8 9
0 8 3 3 7 9 7 3 4 7
 */
package week1.unionfind;

public class Question3 {
	private int[][] id = { { 2, 8, 2, 0, 3, 2, 2, 2, 2, 0 },
			{ 3, 9, 9, 9, 2, 2, 9, 9, 4, 8 }, { 9, 3, 9, 3, 3, 9, 8, 9, 9, 3 },
			{ 0, 3, 6, 3, 4, 4, 6, 7, 8, 9 }, { 0, 8, 3, 3, 7, 9, 7, 3, 4, 7 } };

	public Question3() {
		QuickUnionUF qu1 = new QuickUnionUF(10);
		QuickUnionUF qu2 = new QuickUnionUF(10);
		QuickUnionUF qu3 = new QuickUnionUF(10);
		QuickUnionUF qu4 = new QuickUnionUF(10);
		QuickUnionUF qu5 = new QuickUnionUF(10);
		qu1.setId(id[0]);
		qu2.setId(id[1]);
		qu3.setId(id[2]);
		qu4.setId(id[3]);
		qu5.setId(id[4]);
		drawGraph(qu1);
		//drawGraph(qu2);
		drawGraph(qu3);
		drawGraph(qu4);
		drawGraph(qu5);
	}

	private void drawGraph(QuickUnionUF qu) {
		int[] depth = new int[qu.getId().length];
		for (int i = 0; i < qu.getId().length; i++)
		{
			depth[i] = qu.getDepth(i);
		}
		for (int i = 0; i < depth.length; i++)
		{
			System.out.print(depth[i]);
			if (i != depth.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
		
	}

	public static void main(String args[]) {
		new Question3();
	}
}
