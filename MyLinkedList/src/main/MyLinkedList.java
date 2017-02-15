package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListADT<E>, Iterable<E> {
	
	private Listnode<E> head;
	private Listnode<E> tail;
	private int itemCount; 
	
	public MyLinkedList() {
		head = new Listnode(null);
		tail = head;
		itemCount = 0;
	}

	@Override
	public void add(E item) {
		if(item == null) {
			throw new NullPointerException();
		}
		
		Listnode<E> newNode = new Listnode(item);
		tail.setNext(newNode);
		tail = tail.getNext();
		itemCount++;
		
	}

	@Override
	public void add(int pos, E item) {
		if(item == null) {
			throw new NullPointerException();
		}
		
		if(pos < 0 || pos > itemCount) {
			throw new IndexOutOfBoundsException();
		}
		
		Listnode<E> temp = new Listnode(item);
		
		if(pos == itemCount) {
			tail.setNext(temp);
			tail = temp;
		}
		
		Listnode<E> pre = head;
		int i = 0;
		while (i < pos) {
			pre = pre.getNext();
			i++;
		}
		Listnode<E> next = pre.getNext();
		pre.setNext(temp);
		temp.setNext(next);
		
		itemCount++;
	}

	@Override
	public boolean contains(E item) {
		if(item == null) {
			throw new NullPointerException();
		}
		
		if(itemCount == 0) 
			return false;
		
		
		Listnode<E> current = head;
		while(current.getNext() != null) {
			
			if(current.getNext().getData() == item) {
				return true;
			} else {
				current = current.getNext();
			}
			
		}
		return false;
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
	public E get(int pos) {
		if(pos < 0 || pos >= itemCount) 
			throw new NullPointerException();
		
		int i = 0;
		Listnode<E> current = head.getNext();
		while(i < pos) {
			current = current.getNext();
			i++;
		}
		return current.getData();
	}

	@Override
	public E remove(int pos) {
		if(pos < 0 || pos > itemCount - 1) 
			throw new NullPointerException();
		
		if(itemCount == 0) {
			throw new NoSuchElementException();
		}
		
		
		int i = 0;
		Listnode<E> current = head;
		while(i < pos) {
			current = current.getNext();
			i++;
		}
		Listnode<E> temp = current.getNext();
		if(temp == tail) {
			tail = current;
		} else {
			current.setNext(temp.getNext());
		}
		
		itemCount--;
		return temp.getData();
		
	}

	@Override
	public Iterator<E> iterator() {
		if(itemCount == 0) {
			throw new NullPointerException();
		}
		return new LinkedListIterator(head);
	}
	
	@Override
	public String toString() {
		String str = "[";
		Iterator<E> itr = this.iterator();
		while (itr.hasNext()) {
			str = str + itr.next() + " ";
		}
		str = str.trim() + "]";
		return str;
	}


	

}
