package main;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
	
	private T data;
	private List<GraphNode<T>> successors;
	private List<Integer> weights;
	private boolean isVisited;
	private int order;
	private int shortestEdge; 
	
	public GraphNode(T data) {
		this.data = data;
		this.successors = new ArrayList<GraphNode<T>>();
		this.weights = new ArrayList<Integer>();
		this.isVisited = false;
		this.order = -1;
		this.shortestEdge = -1;
	}
	
	public GraphNode(T data, List<GraphNode<T>> successors, List<Integer> weights) {
		this.data = data;
		this.successors = successors;
		this.weights = weights;
		this.isVisited = false;
		this.order = -1;
		this.shortestEdge = -1;
	}
	
	public void addSuccessor(T data, Integer weight) {
		GraphNode<T> newnode = new GraphNode(data);
		successors.add(newnode);
		weights.add(weight);
	}
	
	public void removeSuccessor(T data) {
		int index = successors.indexOf(data);
		successors.remove(index);
		weights.remove(index);
	}
	
	public boolean getIsVisited(){
		return isVisited;
	}
	
	public void setIsVisited(boolean state){
		isVisited = state;
	}
	
	public List<GraphNode<T>> getSuccessors() {
		
		return successors;
		
	}
	
	public void setOrder(int num) {
		this.order = num;);
	}
	
	public void setShortestEdge(int num) {
		shortestEdge = num;
	}
	
	public int getShortestEdge() {
		return shortestEdge;
	}

}
