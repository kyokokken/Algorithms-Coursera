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

public class Deque<Item> implements Iterable<Item> {

	private ArrayList<Item> items;

	public Deque() {
		items = new ArrayList<Item>();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public int size() {
		return items.size();
	}

	public void addFirst(Item item) {
		items.add(0, item);
	}

	public void addLast(Item item) {
		items.add(items.size() - 1, item);
	}

	public Item removeFirst() {
		return items.remove(0);
	}

	public Item removeLast() {
		return items.remove(items.size() - 1);
	}

	public Iterator<Item> iterator() {
		return items.iterator();
	}

}
