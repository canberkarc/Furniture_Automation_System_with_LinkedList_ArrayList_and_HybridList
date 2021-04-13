import java.util.ListIterator;
public class Deneme{
	public static void main(String[] args){
		KWLinkedList<Integer> a = new KWLinkedList<Integer>();

		a.add(0,2);

		ListIterator<Integer> iter = a.listIterator();
		/*
		int ind = 0;
		while(ind != a.indexOf(4)){
			ind++;
			iter.next();
		}
		*/


		iter.next();
		iter.remove();
		System.out.println(a.indexOf(2));
	}
}