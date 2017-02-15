package main;

public class Listnode <E> {
	
	private E data;
	private Listnode<E> next;
	
	public Listnode(E item) {
		this.data = item;
		this.next = null;
	}
	
	public Listnode(E item, Listnode<E> other) {
		this.data = item;
		this.next = other;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E item) {
		this.data = item;
	}
	
	public void setNext(Listnode<E> next) {
		this.next = next;
	}
	
	public Listnode<E> getNext() {
		return next;
	}
	

}
