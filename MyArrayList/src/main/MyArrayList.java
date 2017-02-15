package main;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {
	
	private int itemCount;
	private T[] itemArray;
	private final int INIT_SIZE = 10;
	private int arraysize;

	public MyArrayList () {
		itemCount = 0;
		itemArray = (T[]) new Object[INIT_SIZE];
	}
	
	public MyArrayList(int arraysize) {
		if(arraysize < 0) 
			throw new IllegalArgumentException();
		
		itemCount = 0;
		this.arraysize = arraysize;
		itemArray = (T[]) new Object[arraysize];
	}
	
	@Override
	public int size() {
		
		return itemCount;
	}

	@Override
	public boolean isEmpty() {
		
		return itemCount == 0;
	}

	@Override
	public boolean contains(Object o) {
		T temp = (T) o;
		for(int i = 0; i < itemCount; i++) {
			if(itemArray[i] != null && itemArray[i].equals(temp)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		if(e == null) 
			return false;
		
		if(itemCount == itemArray.length) {
			expand();
		}
		itemArray[itemCount] = e;
		itemCount++;
		return true;
	}
	
	private void expand() {
		T[] newarray = (T[]) new Object[itemArray.length * 2 + 1];
		for (int i = 0; i < itemArray.length; i++) {
			newarray[i] = itemArray[i];
		}
		itemArray = newarray;
	}

	@Override
	public boolean remove(Object o) {
		if(o == null) 
			return false;
		
		T temp = (T) o;
		if(!contains(o)) 
			return false;
		
		int i;
		for (i = 0; i < itemArray.length; i++) {
			if(itemArray[i].equals(temp)) {
				itemArray[i] = null;
				break;
			}
		}
		for (int k = i; k < itemArray.length - 1; k++) {
			itemArray[k] = itemArray[k + 1];
		}
		itemCount--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		if(!indexValid(index)) 
			throw new IndexOutOfBoundsException();
		return itemArray[index];
	}
	
	private boolean indexValid(int index) {
		return index >= 0 && index < itemCount;
	}

	@Override
	public T set(int index, T element) {
		
		if(!indexValid(index)) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NoSuchElementException();
		}
		
		itemArray[index] = element;
		return itemArray[index];
	}

	@Override
	public void add(int index, T element) {
		if(!indexValid(index)) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NoSuchElementException();
		}
		
		if(itemCount == itemArray.length) {
			expand();
		}
		
		System.arraycopy(itemArray, index, itemArray, index + 1, itemCount - index);
		itemArray[index] = element;
		itemCount++;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new ArrayListIterator<T>(this);
		
	}
	

}
