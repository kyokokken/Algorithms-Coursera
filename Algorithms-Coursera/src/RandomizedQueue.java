/**
 * public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()           // construct an empty randomized queue
   public boolean isEmpty()           // is the queue empty?
   public int size()                  // return the number of items on the queue
   public void enqueue(Item item)     // add the item
   public Item dequeue()              // delete and return a random item
   public Item sample()               // return (but do not delete) a random item
   public Iterator<Item> iterator()   // return an independent iterator over items in random order
}
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

//	private LinkedList<Item> items;
//	private boolean shuffled;
	private ArrayList<Item> items;

	public RandomizedQueue() {
//		items = new LinkedList<Item>();
		items = new ArrayList<Item>();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public int size() {
		return items.size();
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
//		items.addLast(item);
		items.add(item);
//		shuffled = false;
	}

	public Item dequeue() {
		if (items.isEmpty())
			throw new NoSuchElementException();
		int uniform = StdRandom.uniform(items.size());
//		int uniform = 0;
		Item item = items.get(uniform);
		items.set(uniform, items.get(items.size() - 1));
		items.remove(items.size() - 1);
//		Item item = items.remove(0);
//		items.trimToSize();
		if (items.size() < 2)
		{
			items.trimToSize();
		}
		return item;
	}

	public Item sample() {
		if (items.isEmpty())
			throw new NoSuchElementException();
		int uniform = StdRandom.uniform(items.size());
		return items.get(uniform);
	}

	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator<Item>();
	}
	
	@SuppressWarnings("hiding")
	private class RandomizedQueueIterator<Item> implements Iterator<Item>
	{
		
		Item[] a = (Item[]) items.toArray();
		int index = 0;
		
		public RandomizedQueueIterator() {
			StdRandom.shuffle(a);
		}
		
//		private int index = 0;

		
		@Override
		public boolean hasNext() {
			return index < a.length;
		}

		@Override
		public Item next() {
			if (!(index < a.length))
				throw new NoSuchElementException();
			return a[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	
	public static void main(String args[]) {
		System.out.println("RandomizedQueue.main()");
		testEnqueue();
//		testSample();
		testDequeue();
	}

	private static void testDequeue() {
		RandomizedQueue<Boolean> rQueue = new RandomizedQueue<Boolean>();
		System.out.println("Testing dequeue():");
		for (int i = 0; i < 20; i++) {
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				rQueue.enqueue(true);
			for (int k = 0; k < N; k++)
				rQueue.dequeue();
			System.out.println(stopWatch.elapsedTime());
		}
		
	}

	private static void testSample() {
		RandomizedQueue<Boolean> rQueue = new RandomizedQueue<Boolean>();
		System.out.println("Testing sample():");
		for (int i = 0; i < 20; i++) {
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				rQueue.enqueue(true);
			for (int k = 0; k < N; k++)
				rQueue.sample();
			System.out.println(stopWatch.elapsedTime());
		}

	}

	private static void testEnqueue() {
		RandomizedQueue<Boolean> rQueue = new RandomizedQueue<Boolean>();
		System.out.println("Testing enqueue():");
		for (int i = 0; i < 20; i++) {
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				rQueue.enqueue(true);
			System.out.println(stopWatch.elapsedTime());
		}

	}
}
