import java.util.ListIterator;
import java.util.Iterator;

public class HybridList<E>{

	/** Hybrid list
	*/
	KWLinkedList<KWArrayList<E>> hList;

	/** Current index of node
	*/
	private int lSize = 0;

	/** Max number elements that can be in an arraylist
	*/
	private final int MAX_NUMBER = 10;

	/** No parameter constructor
	*/
	public HybridList(){
		hList = new KWLinkedList<KWArrayList<E>>();
		hList.addLast(new KWArrayList<E>());
	}

	public int size(){
		return hList.size();
	}

	/** Add an item to the array list, if full then create new arraylist.
	  @param obj The object to be inserted
	  @throws IndexOutOfBoundsException if the index is out
	  of range (i < 0 || i > size())
	*/
	public void add(E obj) {
		ListIterator<KWArrayList<E>> iter = hList.listIterator(lSize);
		KWArrayList<E> aL = iter.next();
		
		if(aL.size() == MAX_NUMBER){
			KWArrayList<E> nAlist = new KWArrayList<E>();
			nAlist.add(obj);
			hList.addLast(nAlist);
			lSize++;
		}
		else{
			aL.add(obj);
		}
	}

	/** Get the element at position index.
	  @param index Position of item to be retrieved
	  @return The item at index
	*/
	public KWArrayList<E> get(int index) {
		ListIterator<KWArrayList<E>> iter = hList.listIterator(index);
		return iter.next();
	}

	public void removeElement(E obj){
		if(lSize == 0){

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

}