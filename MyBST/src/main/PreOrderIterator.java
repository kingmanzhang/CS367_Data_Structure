package main;

import java.util.Iterator;

public class PreOrderIterator<E> implements Iterator<E> {
	
	private MyQueue<BinaryTreeNode<E>> queue;
	
	public PreOrderIterator(BinaryTreeNode<E> root){
		queue = new MyQueue<>();
		if(root == null) {
			throw new NullPointerException();
		}
		enqueueAux(root);
	}
	
	private void enqueueAux(BinaryTreeNode<E> n) {
		if (n == null) {
			return;
		}
		queue.enqueue(n);
		enqueueAux(n.getLeft());
		enqueueAux(n.getRight());		
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public E next() {
		
		return queue.dequeue().getData();
		
	}

}
