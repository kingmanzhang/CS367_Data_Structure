package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyStackTest {

	@Test
	public void testIsEmptyPush() {
		MyStack<String> stringStack = new MyStack<>();
		boolean result = stringStack.isEmpty();
		assertEquals(true, result);
		stringStack.push("Aaron");
		result = stringStack.isEmpty();
		assertEquals(false, result);
		
	}


	@Test
	public void testPop() {
		MyStack<String> stringStack = new MyStack<>();
		stringStack.push("Aaron");
		stringStack.push("Sharon");
		assertEquals("Sharon", stringStack.pop());
		assertEquals("Aaron", stringStack.pop());
	}

	@Test
	public void testPeek() {
		MyStack<String> stringStack = new MyStack<>();
		stringStack.push("Aaron");
		stringStack.push("Sharon");
		assertEquals("Sharon", stringStack.peek());
	}

}
