package main;

public class EmptyQueueException extends RuntimeException {
	
	public EmptyQueueException() {
		super();
	}
	
	public EmptyQueueException(String str) {
		super(str);
	}

}
