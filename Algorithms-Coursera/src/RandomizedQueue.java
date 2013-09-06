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


import java.util.Iterator;
import java.util.LinkedList;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private LinkedList<Item> items;
	
	public RandomizedQueue()
	{
		items = new LinkedList<Item>();
	}
	
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	public int size()
	{
		return items.size();
	}
	
	public void enqueue(Item item)
	{
		items.addLast(item);
	}
	
	public Item dequeue()
	{
		int uniform = StdRandom.uniform(items.size());
		return items.remove(uniform);
	}
	
	public Item sample()
	{
		int uniform = StdRandom.uniform(items.size());
		return items.get(uniform);
	}
	
	public Iterator<Item> iterator() 
	{
		return items.iterator();
	}
}
