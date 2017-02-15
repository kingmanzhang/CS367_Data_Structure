package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyPriorityQueueTest {


	@Test
	public void testLookup() {
		MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>();
		intQueue.insert(new Integer(100));
		intQueue.insert(new Integer(50));
		assertEquals(true, intQueue.lookup(100));
		assertEquals(false, intQueue.lookup(0));
	}

	@Test
	public void testIsEmpty() {
		MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>();
		assertEquals(true, intQueue.isEmpty());
		intQueue.insert(new Integer(100));
		assertEquals(false, intQueue.isEmpty());
	}

	@Test
	public void testSize() {
		MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>();
		assertEquals(0, intQueue.size());
		intQueue.insert(new Integer(100));
		intQueue.insert(new Integer(50));
		assertEquals(2, intQueue.size());
		intQueue.removeMax();
		assertEquals(1, intQueue.size());
	}

	@Test
	public void testRemoveMax() {
		MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>();
		intQueue.insert(new Integer(100));
		intQueue.insert(new Integer(50));
		intQueue.insert(new Integer(150));
		intQueue.insert(new Integer(30));
		assertEquals(new Integer(150), intQueue.removeMax());
		assertEquals(new Integer(100), intQueue.removeMax());
		assertEquals(new Integer(50), intQueue.removeMax());
		assertEquals(new Integer(30), intQueue.removeMax());
	}

	@Test
	public void testGetMax() {
		MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>();
		intQueue.insert(new Integer(100));
		intQueue.insert(new Integer(50));
		intQueue.insert(new Integer(150));
		intQueue.insert(new Integer(30));
		assertEquals(new Integer(150), intQueue.getMax());
		assertEquals(new Integer(150), intQueue.getMax());
	}

}
