package main;

import java.io.PrintStream;
import java.util.Iterator;

public class MyBST<E extends Comparable<E>> implements Iterable<E>{
	
	private BinaryTreeNode<E> root;
	
	public MyBST() {
		this.root = null;
	}
	
	public void insert(E item) throws DuplicateException{ 
		root = insertAux(root, item);
		
	}
	
	private BinaryTreeNode<E> insertAux(BinaryTreeNode<E> n, E item) throws DuplicateException {
		
		if(n == null) {
			return new BinaryTreeNode(item);
		}
		
		if(item.equals(n.getData())) {
			throw new DuplicateException();
		}
		
		
		if(item.compareTo(n.getData()) < 0) {
			n.setLeft(insertAux(n.getLeft(), item));
			return n;
		}
		
		else {
			n.setRight(insertAux(n.getRight(), item));
			return n;
		}
	}

   
	public void delete(E item) {
		root = deleteAux(root, item);
	}
	
	private BinaryTreeNode<E> deleteAux(BinaryTreeNode<E> n, E item) {
		if(n == null) {
			return null;
		}
		
		if(item.compareTo(n.getData()) < 0) {
			n.setLeft(deleteAux(n.getLeft(), item));
			return n;
		}
		
		if(item.compareTo(n.getData()) > 0) {
			n.setRight(deleteAux(n.getRight(), item));
			return n;
		}
		
		else{
			if(n.getLeft() == null) {
				return n.getRight();
			}
			
			if(n.getRight() == null) {
				return n.getLeft();
			}
			else {
				BinaryTreeNode<E> temp = n.getRight();
				while(temp.getLeft() != null && temp.getLeft().getLeft() != null) {
					temp = temp.getLeft(); //temp is the parent of leftmost node
				}
				E replacement = temp.getData();
				n.setData(replacement);
				n.setRight(deleteAux(n.getRight(), replacement));
				return n;
			}
			}
	}

    
	public boolean lookup(E item) {
		
		return lookupAux(root, item);
		
	}
	
	private boolean lookupAux(BinaryTreeNode<E> n, E item) {
		if(n == null) {
			return false;
		}
		
		if(n.getData().equals(item)) {
			return true;
		}
		
		if(item.compareTo(n.getData()) < 0) {
			return lookupAux(n.getLeft(), item);
		} else {
			return lookupAux(n.getRight(), item);
		}
		
	}

  
	public void print(PrintStream p) {
		
		Iterator<E> itr = this.iterator();
		p.print("[");
		while(itr.hasNext()) {
			p.print(itr.next() + " ");
		}
		p.print("]");
		
	}
	
	public void printPreOrder(PrintStream p) {
		Iterator<E> itr = this.preOrderIterator();
		p.print("[");
		while(itr.hasNext()) {
			p.print(itr.next() + " ");
		}
		p.print("]");
		
	}
	
	public void printPostOrder(PrintStream p) {
		Iterator<E> itr = this.postOrderIterator();
		p.print("[");
		while(itr.hasNext()) {
			p.print(itr.next() + " ");
		}
		p.print("]");
		
	}

	@Override
	public Iterator<E> iterator() { //default: level order traverse
		return new LevelOrderIterator<E>(root);
	}
	
	public Iterator<E> preOrderIterator() {
		
		return new PreOrderIterator<E>(root);
		
	}
	
	public Iterator<E> postOrderIterator(){
		
		return new PostOrderIterator<E>(root);
		
	}

}
