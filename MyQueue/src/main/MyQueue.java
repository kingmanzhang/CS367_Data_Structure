package main;

public class MyQueue<E> implements QueueADT<E>{
	
	private MyLinkedList<E[]> list; //implement with a linked list of arrays
	private int front; //beginning position in current array
	private int end; //ending position in current array
	private int totalCount; //count total items
	private final int DEFAULT_SIZE = 3; //default of subarrays
	
	public MyQueue() {
		this.list = new MyLinkedList<>();
		front = 0;
		end = 0;
		totalCount = 0;
	
	}

	@Override
	public boolean isEmpty() {
		
		return totalCount == 0;
	}

	@Override
	public void enqueue(E ob) {
		if(list.size() == 0 || end == DEFAULT_SIZE - 1) {
			E[] newArray = (E[]) new Object[DEFAULT_SIZE];
			list.add(newArray);
			end = 0;
		}
		
		list.get(list.size() - 1)[end] = ob;
		end++;
		totalCount++;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(totalCount == 0) {
			throw new EmptyQueueException();
		}
		
		E temp = list.get(0)[front];
		front++;
		if(front == DEFAULT_SIZE - 1) {
			list.remove(0);
			front = 0;
		}
		totalCount--;
		return temp;
	}

}
