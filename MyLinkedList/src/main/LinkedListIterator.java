package main;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
	
	private Listnode<E> node;
	
	public LinkedListIterator(Listnode<E> first) {
		this.node = first;
	}

	@Override
	public boolean hasNext() {
		return node.getNext() != null;
	}

	@Override
	public E next() {
		node = node.getNext();
		return node.getData();
	}

}
