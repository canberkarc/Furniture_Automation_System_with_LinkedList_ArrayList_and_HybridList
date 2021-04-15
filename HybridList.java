import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HybridList<E>{

	/** Hybrid list
	*/
	KWLinkedList<KWArrayList<E>> hList;

	/** A reference to the head of the list. */
  	private Node<E> head = null;

  	/** A reference to the end of the list. */
  	private Node<E> tail = null;

	/** Size of linked list
	*/
	private int size = 0;

	/** Count of elements 
	*/
	private int elCount = 0;

	/** Max number elements that can be in an arraylist
	*/
	private final int MAX_NUMBER = 5;

	/** No parameter constructor
	*/
	public HybridList(){
		hList = new KWLinkedList<KWArrayList<E>>();
		hList.addLast(new KWArrayList<E>());
	}

	public int size(){
		return hList.size();
	}

	public int getElCount(){
		return elCount;
	}

	public void add() {
		KWArrayList<E> nAlist = new KWArrayList<E>();
		hList.addLast(nAlist);
		size++;
	}

	/** Add an item to the array list, if full then create new arraylist.
	  @param obj The object to be inserted
	  @throws IndexOutOfBoundsException if the index is out
	  of range (i < 0 || i > size())
	*/
	public void addElement(E obj) {
		ListIterator<KWArrayList<E>> iter = hList.listIterator(size);
		KWArrayList<E> aL = iter.next();
		
		if(aL.size() == MAX_NUMBER){
			KWArrayList<E> nAlist = new KWArrayList<E>();
			nAlist.add(obj);
			hList.addLast(nAlist);
			size++;
		}
		else{
			aL.add(obj);
		}
		elCount++;
	}

	/** Get the element at position index.
	  @param index Position of item to be retrieved
	  @return The item at index
	*/
	public KWArrayList<E> get(int index) {
		ListIterator<KWArrayList<E>> iter = hList.listIterator(index);
		return iter.next();
	}

	public void remove(int i){
		// Validate i parameter.
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Invalid index " + i);
		}

		ListIterator<KWArrayList<E>> iter = hList.listIterator(i);
		iter.next();
		iter.remove();
		size--;
	}

	public void removeElement(E obj){
		if(size == 0){
			throw new NoSuchElementException();
		}

		ListIterator<KWArrayList<E>> iter = hList.listIterator(0);
		while(iter.hasNext()){
			KWArrayList<E> aL = iter.next();
			if(aL.indexOf(obj) != -1){
				aL.remove(aL.indexOf(obj));
				if(aL.size() == 0) /* If array list size becomes 0 then delete it*/
					iter.remove();

				break;
			}
		}
	}

	/**
	* Method to find the index of the first occurence of an item in the list
	* @param target The item being sought
	* @return The index of the first occurence of the tartet item
	*         or -1 if the item is not found.
	*/
	public int indexOf(Object target) {
	    Iterator<KWArrayList<E>> itr = hList.iterator();
	    int index = 0;
	    while (itr.hasNext()) {
	        if (target.equals(itr.next())) {
	            return index;
	        } else {
	            index++;
	        }
	    }
	    return -1;
	}

	/** A Node is the building block for a double-linked list. */
	private static class Node < E > {
		/** The data value. */
		private KWArrayList<E> data;

		/** The link to the next node. */
		private Node < E > next = null;

		/** The link to the previous node. */
		private Node < E > prev = null;

		/** Construct a node with the given data value.
		    @param obj The data value
		 */
		private Node(KWArrayList<E> obj) {
		  data = obj;
		}
	} 

	/** Inner class to implement the ListIterator interface. */
	private class HBListIter{
    
	    /** A reference to the next item. */
	    private Node<E> nextItem;

	    /** A reference to the last item returned. */
	    private Node<E>  lastItemReturned;

	    /** The index of the current item. */
	    private int index = 0;

	    /** Construct a HBListIter that will reference the ith item.
	        @param i The index of the item to be referenced
	     */
	    public HBListIter(int i) {
	      // Validate i parameter.
	      if (i < 0 || i > size) {
	        throw new IndexOutOfBoundsException(
	            "Invalid index " + i);
	      }
	      lastItemReturned = null; // No item returned yet.
	      // Special case of last item.
	      if (i == size) {
	        index = size;
	        nextItem = null;
	      }
	      else { // Start at the beginning
	        nextItem = head;
	        for (index = 0; index < i; index++) {
	          nextItem = nextItem.next;
	        }
	      }
	    }

	    /** Indicate whether movement forward is defined.
	        @return true if call to next will not throw an exception
	     */
	    public boolean hasNext() {
	      return nextItem != null;
	    }

	    /** Move the iterator forward and return the next item.
	        @return The next item in the list
	        @throws NoSuchElementException if there is no such object
	     */
	    public KWArrayList<E> next() {
	      if (!hasNext()) {
	        throw new NoSuchElementException();
	      }
	      lastItemReturned = nextItem;
	      nextItem = nextItem.next;
	      index++;
	      return lastItemReturned.data;
	    }

	    /** Indicate whether movement backward is defined.
	        @return true if call to previous will not throw an exception
	     */
	    public boolean hasPrevious() {
	      return (nextItem == null && size != 0)
	          || nextItem.prev != null;
	    }

	    /** Return the index of the next item to be returned by next
	            @return the index of the next item to be returned by next
	     */
	    public int nextIndex() {
	      return index;
	    }

	    /** Return the index of the next item to be returned by previous
	           @return the index of the next item to be returned by previous
	     */
	    public int previousIndex() {
	      return index - 1;
	    }

	    /** Move the iterator backward and return the previous item.
	        @return The previous item in the list
	        @throws NoSuchElementException if there is no such object
	     */
	    public KWArrayList<E> previous() {
	      if (!hasPrevious()) {
	        throw new NoSuchElementException();
	      }
	      if (nextItem == null) { // Iterator past the last element
	        nextItem = tail;
	      }
	      else {
	        nextItem = nextItem.prev;
	      }
	      lastItemReturned = nextItem;
	      index--;
	      return lastItemReturned.data;
	    }
	}
}