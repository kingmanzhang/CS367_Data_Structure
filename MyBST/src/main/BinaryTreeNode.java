package main;

public class BinaryTreeNode<E> {
	private E data;
	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;
	
	public BinaryTreeNode(E item) {
		this.data = item;
		left = null;
		right = null;
	}
	
	public BinaryTreeNode(E item, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
		this.data = item;
		this.left = left;
		this.right = right;
	}
	
	public void setData(E data) {
		
		this.data = data;
		
	}
	
	public E getData() {
		return data;
	}
	
	public void setLeft(BinaryTreeNode<E> left) {
		
		this.left = left;
		
	}
	
	public BinaryTreeNode<E> getLeft() {
		
		return left;
		
	}
	
	public void setRight(BinaryTreeNode<E> right) {
		
		this.right = right;
		
	}
	
	public BinaryTreeNode<E> getRight() {
		
		return right;
		
	}

}
