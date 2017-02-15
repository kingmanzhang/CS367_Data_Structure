package main;

import java.util.Iterator;

public class PostOrderIterator<E> implements Iterator<E> {
	
	private MyQueue<BinaryTreeNode<E>> queue;
	
	public PostOrderIterator(BinaryTreeNode<E> root){
		queue = new MyQueue<>();
		enqueueAux(root);
	}
	
	public void enqueueAux(BinaryTreeNode<E> n) {//not sure what's wrong
		
		if(n == null) {
			return;
		}
		
		enqueueAux(n.getLeft());

		enqueueAux(n.getRight());
				
		queue.enqueue(n);
		
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
