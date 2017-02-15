package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyLinkedListTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAddIntE() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		testlist.add("Aaron");
		testlist.add("Sharon");
		testlist.add(0, "Wisconsin");
		String result = testlist.get(0);
		assertEquals("Wisconsin", result);
	}

	@Test
	public void testContains() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		testlist.add("Aaron");
		testlist.add("Sharon");
		boolean result = testlist.contains("Aaron");
		assertEquals(true, result);
		result = testlist.contains("AARON");
		assertEquals(false, result);
	}

	@Test
	public void testSize() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		int size = testlist.size();
		assertEquals(0, size);
		testlist.add("Aaron");
		size = testlist.size();
		assertEquals(1, size);
	}

	@Test
	public void testIsEmpty() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		boolean empty = testlist.isEmpty();
		assertEquals(true, empty);
		testlist.add("Aaron");
		empty = testlist.isEmpty();
		assertEquals(false, empty);
	}

	@Test
	public void testGet() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		testlist.add("Aaron");
		testlist.add("Sharon");
		String toGet = testlist.get(0);
		assertEquals("Aaron", toGet);
		toGet = testlist.get(1);
		assertEquals("Sharon", toGet);
	}

	@Test
	public void testRemove() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		testlist.add("Aaron");
		testlist.add("Sharon");
		testlist.add(0, "Wisconsin");
		String result = testlist.remove(0);
		assertEquals("Wisconsin", result);
		testlist.add(0, "Wisconsin");
		result = testlist.remove(2);
		assertEquals("Sharon", result);
	}
	
	@Test
	public void testIteration() {
		MyLinkedList<String> testlist = new MyLinkedList<>();
		testlist.add("Aaron");
		testlist.add("Sharon");
		testlist.add(0, "Wisconsin");
		String result = testlist.toString();
		assertEquals("[Wisconsin Aaron Sharon]", result);
	}

}
