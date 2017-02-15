package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PostOrderIteratorImproved<E> implements Iterator<E>  {
	
	private MyStack<BinaryTreeNode<E>> stack;
	
	public PostOrderIteratorImproved(BinaryTreeNode<E> root) {
		stack = new MyStack<BinaryTreeNode<E>>();
		addLeft(root);
	}
	

	@Override
	public boolean hasNext() {
		
		return !stack.isEmpty();
		
	}

	@Override
	public E next() {
		
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		
		BinaryTreeNode<E> temp = stack.peek();;
      while (temp.getRight() != null) {//Bug: it will repeatly add nodes that have been processed
      	addLeft(temp.getRight());
      	temp = stack.peek();
      }

		return stack.pop().getData();
	}
	
	private void addLeft(BinaryTreeNode<E> n) {
		
		while(n != null) {
			stack.push(n);
			n = n.getLeft();
		}
		
	}

}
