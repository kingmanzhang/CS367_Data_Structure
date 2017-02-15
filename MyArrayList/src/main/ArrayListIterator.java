package main;
import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T> {
	
	private MyArrayList<T> alist;
	private int index;
	
	public ArrayListIterator(MyArrayList<T> list) {
		this.alist = list;
		this.index = -1;
	}

	@Override
	public boolean hasNext() {
		
		return index < alist.size() - 1;
	}

	@Override
	public T next() {
		index++;
		return alist.get(index);
	}
	

}
