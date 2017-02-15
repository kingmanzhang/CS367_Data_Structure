package main;
import java.util.Iterator;

public class MyLinkedListTest {
	public static void main(String args[]) {
		MyArrayList<String> mylist = new MyArrayList<>();
		System.out.println("list size " + mylist.size());
		System.out.println("is empty? " + mylist.isEmpty());
		mylist.add("computer");
		mylist.add("desk");
		mylist.add("lamp");
		System.out.println("list size " + mylist.size());
		System.out.println("is empty? " + mylist.isEmpty());
		
		mylist.add("office");
		mylist.add("poster");
		System.out.println("list size " + mylist.size());
		System.out.println("is empty? " + mylist.isEmpty());
		
		mylist.remove("computer");
		System.out.println("list size " + mylist.size());
		System.out.println("is empty? " + mylist.isEmpty());
		
		System.out.println("first item is " + mylist.get(0));
		System.out.println("second item is " + mylist.get(1));
		
		Iterator<String> itr = mylist.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
