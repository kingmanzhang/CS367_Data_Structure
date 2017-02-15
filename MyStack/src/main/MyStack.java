package main;

import java.util.EmptyStackException;


public class MyStack<E> implements StackADT<E> {

	private MyLinkedList<E> list;
	
	public MyStack() {
		
		list = new MyLinkedList<E>();
		
	}

	@Override
	public boolean isEmpty() {
		
		return list.size() == 0;
		
	}

	@Override
	public void push(E ob) {
		
		list.add(ob);
		
	}

	@Override
	public E pop() throws EmptyStackException {
		if (list.size() == 0) 
			throw new EmptyStackException();
		E toPop = (E) list.remove(list.size() - 1);
		return toPop;
	}

	@Override
	public E peek() throws EmptyStackException {
		if (list.size() == 0) 
			throw new EmptyStackException();
		E toPop = (E) list.remove(list.size() - 1);
		push(toPop);
		return toPop;
	}

}
