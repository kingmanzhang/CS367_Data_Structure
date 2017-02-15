package main;

import java.util.Iterator;

public class InOrderIterator<E> implements Iterator<E> {
	
	private MyQueue<BinaryTreeNode<E>> queue;
	
	public InOrderIterator(BinaryTreeNode<E> root){
		queue = new MyQueue<>();
		queue.enqueue(root);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	@Override
	public E next() {
		BinaryTreeNode<E> temp = queue.dequeue();
		if(temp.getLeft() != null) {
			queue.enqueue(temp.getLeft());
		}
		if(temp.getRight() != null) {
			queue.enqueue(temp.getRight());
		}
		return temp.getData();
	}

}
