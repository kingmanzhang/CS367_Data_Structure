package main;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MyBSTTest {

	@Test
	public void testInsert() throws DuplicateException {
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
	}

	@Test
	public void testDelete() throws DuplicateException {
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
		intTree.insert(new Integer(8));
		intTree.insert(new Integer(11));
		assertEquals(true, intTree.lookup(10));
		assertEquals(true, intTree.lookup(11));
		assertEquals(false, intTree.lookup(12));
		intTree.delete(10);
		assertEquals(false, intTree.lookup(10));
		intTree.delete(8);
		assertEquals(false, intTree.lookup(8));
		
	}

	@Test
	public void testLookup() throws DuplicateException {
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
		intTree.insert(new Integer(8));
		intTree.insert(new Integer(11));
		assertEquals(true, intTree.lookup(10));
		assertEquals(true, intTree.lookup(11));
		assertEquals(false, intTree.lookup(12));
	}

	@Test
	public void testPrint() throws DuplicateException { //traverse by in-level
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
		intTree.insert(new Integer(6));
		intTree.insert(new Integer(14));
		intTree.insert(new Integer(5));
		intTree.insert(new Integer(8));
		intTree.insert(new Integer(13));
		intTree.insert(new Integer(16));
		intTree.insert(new Integer(7));
		intTree.insert(new Integer(9));
		intTree.print(p);
		String result = os.toString();
		assertEquals("[10 6 14 5 8 13 16 7 9 ]", result);
		
	}
	
	@Test 
	public void testPrintPreOrder() throws DuplicateException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
		intTree.insert(new Integer(6));
		intTree.insert(new Integer(14));
		intTree.insert(new Integer(5));
		intTree.insert(new Integer(8));
		intTree.insert(new Integer(13));
		intTree.insert(new Integer(16));
		intTree.insert(new Integer(7));
		intTree.insert(new Integer(9));
		intTree.printPreOrder(p);
		String result = os.toString();
		assertEquals("[10 6 5 8 7 9 14 13 16 ]", result);
	}
	
	@Test 
	public void testPrintPostOrder() throws DuplicateException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		MyBST<Integer> intTree = new MyBST<>();
		intTree.insert(new Integer(10));
		intTree.insert(new Integer(6));
		intTree.insert(new Integer(14));
		intTree.insert(new Integer(5));
		intTree.insert(new Integer(8));
		intTree.insert(new Integer(13));
		intTree.insert(new Integer(16));
		intTree.insert(new Integer(7));
		intTree.insert(new Integer(9));
		intTree.printPostOrder(p);
		String result = os.toString();
		assertEquals("[5 7 9 8 6 13 16 14 10 ]", result);
	}

}
