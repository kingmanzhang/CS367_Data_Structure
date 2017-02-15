package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MyGraph<T> {
	
	private List<GraphNode<T>> nodes;
	
	public MyGraph() {
		nodes = new ArrayList<GraphNode<T>>();
	}
	
	public void addNode(GraphNode<T> graphnode){
		if(nodes.contains(graphnode)) {
			throw new DuplicateNodeException();
		}
		if(graphnode == null) {
			throw new NullPointerException();
		}
		nodes.add(graphnode);
	}
	
	public List<GraphNode<T>> getNodes() {
		return nodes;
	}
	
	public void removeNode(GraphNode<T> graphnode){
		if(graphnode == null) {
			throw new NullPointerException();
		}
		nodes.remove(graphnode);
	}
	
	public void dfs(GraphNode<T> n) {
		n.setIsVisited(true);
		for(GraphNode<T> m : n.getSuccessors()) {
			if(!m.getIsVisited()) {
				dfs(m);
			}
		}
	}
	
	public void resetVisited(boolean state) {
		for (GraphNode<T> m : this.getNodes()) {
			m.setIsVisited(state);
		}
	}
	
	
	public boolean pathExits(GraphNode<T> n, GraphNode<T> k) {
		resetVisited(false);
		dfs(n);
		return k.getIsVisited();
	}
	
	public ArrayList<GraphNode<T>> reachableNodes(GraphNode<T> n) {
		ArrayList<GraphNode<T>> in = new ArrayList<GraphNode<T>>();
		for(GraphNode<T> m : this.getNodes()) {
			if(pathExits(n, m)) {
				in.add(m);
			}
		}
		return in;
	}
	
	public boolean isConnected() {
		for(GraphNode<T> m : this.getNodes()) {
			for (GraphNode<T> n : this.getNodes()) {
				if(!pathExits(n, m)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean cycleExits(GraphNode<T> n) { //if there is a cycle from n
		
		if(n.getSuccessors().contains(n)) { //n is its own successor
			return true;
		}
		
		for (GraphNode<T> m : n.getSuccessors()) {
			if(pathExits(m, n)) { //n connects to itself
				return true;
			}	
		}
		return false;
	}
	
	public boolean cycleExits() { //if there is a cycle anywhere
		
		for (GraphNode<T> m : this.getNodes()) {
			if(cycleExits(m)) {
				return true;
			}
		}
		return false;
	}
	
	public int topNum(GraphNode<T> n, int num) {
		
		n.setIsVisited(true);
		for(GraphNode<T> m : n.getSuccessors()) {
			if(!m.getIsVisited()) {
				num = topNum(m, num);
			}
		}
		
		n.setOrder(num);
		return num - 1;
	}
	
	public void topOrder() {
		int max = this.getNodes().size();
		for (GraphNode<T> n : this.getNodes()) {
			max = topNum(n, max);
		}
	}
	
	public void bfs(GraphNode<T> n){ 
		
		MyQueue<GraphNode<T>> queue = new MyQueue<>();
		n.setIsVisited(true);
		queue.enqueue(n);
		while(!queue.isEmpty()) {
			GraphNode<T> temp = queue.dequeue();
			for(GraphNode<T> m : temp.getSuccessors()) {
				if(!m.getIsVisited()) {
					m.setIsVisited(true);
					queue.enqueue(m);
				}
			}
		}
	}
	
	public void shortestEdge(GraphNode<T> n) {
		
		MyQueue<GraphNode<T>> queue = new MyQueue<>();
		n.setIsVisited(true);
		n.setShortestEdge(0);
		queue.enqueue(n);
		while(!queue.isEmpty()) {
			GraphNode<T> temp = queue.dequeue();
			for(GraphNode<T> m : temp.getSuccessors()) {
				if(!m.getIsVisited()) {
					m.setIsVisited(true);
					m.setShortestEdge(temp.getShortestEdge() + 1);
					queue.enqueue(m);
				}
			}
		}
	}
	
	public void shortestWeightPath(GraphNode<T> n) {
		
	}

}
