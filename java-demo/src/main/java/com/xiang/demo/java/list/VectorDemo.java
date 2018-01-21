package com.xiang.demo.java.list;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		Vector<Object> v = new Vector<Object>(3, 2);
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " + v.capacity());

		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Initial capacity: " + v.capacity());

		v.addElement(new Double(5.34));
		System.out.println("Initial capacity: " + v.capacity());

		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("Current capacity: " + v.capacity());

		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		System.out.println("First element: " + (Integer) v.firstElement());

		System.out.println("Last element: " + (Integer) v.lastElement());

		if (v.contains(new Integer(3))) {			
			System.out.println("Vector contains 3.");
		}
		// enumerate the elements in the vector.
		Enumeration<Object> vEnum = v.elements();
		System.out.println("\nElements in vector:");
		while (vEnum.hasMoreElements())
			System.out.print(vEnum.nextElement() + " ");
		System.out.println();

	}

}
