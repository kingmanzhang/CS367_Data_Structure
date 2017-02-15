package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyArrayListTest {

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
	public void testSize() {
		MyArrayList<String> mylist = new MyArrayList<>();
		int size = mylist.size();
		assertEquals(0 , size);
		
		mylist.add("Aaron");
		size = mylist.size();
		assertEquals(1, size);
		
	}

	@Test
	public void testIsEmpty() {
		MyArrayList<String> mylist = new MyArrayList<>();
		assertEquals(true, mylist.isEmpty());
		
		mylist.add("Aaron");
		assertEquals(false, mylist.isEmpty());
	}

}
