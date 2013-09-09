/**
 * public class Deque<Item> implements Iterable<Item> {
   public Deque()                     // construct an empty deque
   public boolean isEmpty()           // is the deque empty?
   public int size()                  // return the number of items on the deque
   public void addFirst(Item item)    // insert the item at the front
   public void addLast(Item item)     // insert the item at the end
   public Item removeFirst()          // delete and return the item at the front
   public Item removeLast()           // delete and return the item at the end
   public Iterator<Item> iterator()   // return an iterator over items in order from front to end
}
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private ArrayList<Item> itemsFront;
	private ArrayList<Item> itemsBack;
//	private LinkedList<Item> items;

	public Deque() {
//		items = new ArrayList<Item>();
//		items = new LinkedList<Item>();
		itemsFront = new ArrayList<Item>();
		itemsBack = new ArrayList<Item>();
	}

	public boolean isEmpty() {
//		return items.isEmpty();
		return itemsFront.isEmpty() && itemsBack.isEmpty();
	}

	public int size() {
//		return items.size();
		return itemsFront.size() + itemsBack.size(); 
	}

	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
//		items.add(0, item);
		itemsFront.add(item);
	}

	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		itemsBack.add(item);
	}

	public Item removeFirst() {
		Item i = null;
		if (itemsFront.isEmpty() && itemsBack.isEmpty())
			throw new java.util.NoSuchElementException();
		if (!itemsFront.isEmpty())
		{
			i = itemsFront.remove(itemsFront.size() - 1);
		}
		else if (!itemsBack.isEmpty())
		{
			i = itemsBack.remove(0);
		}
		if (itemsBack.size() + itemsFront.size() < 2)
		{
			itemsBack.trimToSize();
			itemsFront.trimToSize();
		}
		
		
//		Item deletedItem = items.remove(0);
//		if (items.size() < currentSize / 4)
//		{
////			items.trimToSize();
//		}
	
//		return deletedItem;
		return i;
	}

	public Item removeLast() {
//		if (items.isEmpty())
//			throw new java.util.NoSuchElementException();
//		Item deletedItem = items.remove(items.size() - 1);
//		if (items.size() < currentSize / 4)
//		{
////			items.trimToSize();
//		}
//		return deletedItem;
		
		Item i = null;
		if (itemsFront.isEmpty() && itemsBack.isEmpty())
			throw new java.util.NoSuchElementException();
		if (!itemsBack.isEmpty())
		{
			i = itemsBack.remove(itemsBack.size() - 1);
		}
		else if (!itemsFront.isEmpty())
		{
			i = itemsFront.remove(0);
		}
		if (itemsBack.size() + itemsFront.size() < 2)
		{
			itemsBack.trimToSize();
			itemsFront.trimToSize();
		}
		return i;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

			private int index = 0;
			@Override
			public boolean hasNext() {
//				return index < items.size();
				return index < itemsFront.size() + itemsBack.size();
				
			}

			@Override
			public Item next() {
//				if (!(index < items.size()))
//					throw new  NoSuchElementException();
//				return items.get(index++);
				if (!(index < itemsFront.size() + itemsBack.size()))
					throw new NoSuchElementException();
				
				Item i = null;
				if (index < itemsBack.size())
				{
					i = itemsBack.get(index);
				}
				else
				{
					i = itemsFront.get(itemsFront.size() - 1 - (index - itemsBack.size()));
				}
				index++;
				return i;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
				
			}
		};
	}
	
	public static void main(String args[])
	{
		System.out.println("Deque.main()");
		testAddFirst();
		testRemoveFirst();
		testAddLast();
		testRemoveLast();
		testIterator();
		
		
		
		
	}

	private static void testIterator() {
		Deque<Integer> deque = new Deque<Integer>();
		System.out.println("Testing iterator():");
		for (int i = 1; i < 20; i++)
		{
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			Iterator<Integer> it = deque.iterator();
			for (int j = 0; j < N; j++)
				deque.addFirst(j);
			while (it.hasNext()) {
				Integer next = it.next();
//				System.out.println(next);
			}
			System.out.println(stopWatch.elapsedTime());
		}

		
	}

	private static void testRemoveLast() {
		Deque<Boolean> deque = new Deque<Boolean>();
		System.out.println("Testing removeLast():");
		for (int i = 15; i < 20; i++)
		{
			
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				deque.addLast(true);
			for (int k = 0; k < N; k++)
				deque.removeLast();
			System.out.println(stopWatch.elapsedTime());
		}
		
		

		
	}

	private static void testAddLast() {
		Deque<Boolean> deque = new Deque<Boolean>();
		System.out.println("Testing addLast():");
		for (int i = 15; i < 20; i++)
		{
			
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				deque.addLast(true);
			System.out.println(stopWatch.elapsedTime());
		}

		
	}

	private static void testRemoveFirst() {
		Deque<Boolean> deque = new Deque<Boolean>();
		System.out.println("Testing removeFirst():");
		for (int i = 15; i < 20; i++)
		{
			
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				deque.addFirst(true);
			for (int k = 0; k < N; k++)
				deque.removeFirst();
			System.out.println(stopWatch.elapsedTime());
		}
		
		
	}

	private static void testAddFirst() {
		Deque<Boolean> deque = new Deque<Boolean>();
		System.out.println("Testing addFirst():");
		for (int i = 15; i < 20; i++)
		{
			
			int N = (int) Math.pow(2, i);
			System.out.print("N = " + N + " ... ");
			Stopwatch stopWatch = new Stopwatch();
			for (int j = 0; j < N; j++)
				deque.addFirst(true);
			System.out.println(stopWatch.elapsedTime());
		}
		
	}
}
