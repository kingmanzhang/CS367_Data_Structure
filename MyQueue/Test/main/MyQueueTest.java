package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyQueueTest {

	@Test
	public void testIsEmpty() {
		MyQueue<String> queue = new MyQueue<>();
		boolean result = queue.isEmpty();
		assertEquals(true, result);
		
		queue.enqueue("Aaron");
		result = queue.isEmpty();
		assertEquals(false, result);
	}

	@Test
	public void testEnqueue() {
		MyQueue<String> queue = new MyQueue<>();
		queue.enqueue("Aaron");
		queue.enqueue("Sharon");
		queue.enqueue("Wisconsin");
		queue.enqueue("Michigan");
		boolean result = queue.isEmpty();
		assertEquals(false, result);
	}

	@Test
	public void testDequeue() {
		MyQueue<String> queue = new MyQueue<>();
		queue.enqueue("Aaron");
		queue.enqueue("Sharon");
		queue.enqueue("Wisconsin");
		queue.enqueue("Michigan");
		assertEquals("Aaron", queue.dequeue());
		assertEquals("Sharon", queue.dequeue());
		assertEquals("Wisconsin", queue.dequeue());
		assertEquals("Michigan", queue.dequeue());
	}

}
