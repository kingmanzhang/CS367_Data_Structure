package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<E extends Comparable<E>> {
	
	private E[] array;
	private int itemCount;
	private final int DEFAULT_SIZE = 10;
	
	public MyPriorityQueue(){
		array = (E[]) new Comparable[DEFAULT_SIZE];
		itemCount = 0;
	}
	
	public MyPriorityQueue(int size) throws IOException{ 
		if(size < 0) {
			throw new IOException();
		}
		array = (E[]) new Comparable[size];
		itemCount = 0;

	}
	
	public void insert(E item) {
		if(item == null) {
			throw new NullPointerException();
		}
		
		itemCount++;
		if(itemCount == array.length) {
			expand();
		}
		
		array[itemCount] = item;
		int k = itemCount;
		while(k > 1) {
			if(array[k].compareTo(array[k/2]) > 0) {
				E temp = array[k];
				array[k] = array[k / 2];
				array[k / 2] = temp;
			}
			k = k / 2;
		}
		
	}
	
	private void expand() {
		E[] temp = (E[]) new Comparable[array.length * 2 + 1];
		System.arraycopy(array, 1, temp, 1, array.length - 1);
		array = temp;
	}
	
	
	public boolean lookup(E item) {
		for (int i = 1; i <= itemCount; i++) {
			if(array[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return itemCount == 0;
	}
	
	public int size() {
		return itemCount;
	}
	
	public E removeMax() {
		if(itemCount == 0) {
			throw new NoSuchElementException();
		}
		E max = array[1];
		
		int k = 1;
		array[1] = array[itemCount];
		E temp;
		while(2 * k < itemCount) {
			if (array[k].compareTo(array[2 * k]) < 0 ||
					array[k].compareTo(array[2 * k + 1]) < 0) {
				if(array[2 * k].compareTo(array[2 * k + 1]) < 0) {
					temp = array[2 * k + 1];
					array[2 * k + 1] = array[k];
					array[k] = temp;
					k = 2 * k + 1;
					
				} else {
					temp = array[2 * k];
					array[2 * k] = array[k];
					array[k] = temp;
					k = 2 * k;	
				}
				
			} else {
				break;
			}
			
		}
		itemCount--;
		return max;
	}
	
	public E getMax() {
		if(itemCount == 0) {
			throw new NoSuchElementException();
		}
		return array[1];
	}


	

}
