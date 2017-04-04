/**
 * 
 */
package com.flatironschool.javacs;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class MyArrayListTest {

	private List<Integer> mal;
	private List<Integer> list;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		mal = new MyArrayList<Integer>();
		mal.addAll(list);
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyArrayList() {
		assertThat(mal.size(), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		for (int i = 4; i < 20; i++) {
			mal.add(i);
		}
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mal.get(18), is(new Integer(19)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntT() {
		mal.add(1, 5);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mal.get(1), is(new Integer(5)));
		assertThat(mal.size(), is(4));
		
		try {
		    mal.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mal.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
		
		mal.add(0, 6);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mal.get(0), is(6));

		mal.add(5, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mal.get(5), is(new Integer(7)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsT() {
		mal.addAll(list);
		mal.addAll(list);
		mal.addAll(list);
		assertThat(mal.size(), is(12));
		assertThat(mal.get(5), is(new Integer(3)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		mal.clear();
		assertThat(mal.size(), is(0));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertThat(mal.contains(1), equalTo(true));
		assertThat(mal.contains(4), equalTo(false));
		assertThat(mal.contains(null), equalTo(false));
		mal.add(null);
		assertThat(mal.contains(null), equalTo(true));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#containsAll(java.util.Collection)}.
	 */
	@Test
	public void testContainsAll() {
		assertThat(mal.containsAll(list), equalTo(true));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		assertThat(mal.get(1), is(new Integer(2)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertThat(mal.indexOf(1), is(0));
		assertThat(mal.indexOf(2), is(1));
		assertThat(mal.indexOf(3), is(2));
		assertThat(mal.indexOf(4), is(-1));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertThat(mal.isEmpty(), equalTo(false));
		mal.clear();
		assertThat(mal.isEmpty(), equalTo(true));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> iter = mal.iterator();
		assertThat(iter.next(), is(new Integer(1)));
		assertThat(iter.next(), is(new Integer(2)));
		assertThat(iter.next(), is(new Integer(3)));
		assertThat(iter.hasNext(), equalTo(false));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#lastIndexOf(java.lang.Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		mal.add(2);
		assertThat(mal.lastIndexOf(new Integer(2)), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		boolean flag = mal.remove(new Integer(2));
		assertThat(flag, equalTo(true));
		assertThat(mal.size(), is(2));
		assertThat(mal.get(1), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mal.remove(new Integer(1));
		assertThat(flag, equalTo(true));
		assertThat(mal.size(), is(1));
		assertThat(mal.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mal.remove(new Integer(5));
		assertThat(flag, equalTo(false));
		assertThat(mal.size(), is(1));
		assertThat(mal.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mal.remove(new Integer(3));
		assertThat(flag, equalTo(true));
		assertThat(mal.size(), is(0));
		//System.out.println(Arrays.toString(mal.toArray()));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		Integer val = mal.remove(1);
		assertThat(val, is(new Integer(2)));
		assertThat(mal.size(), is(2));
		assertThat(mal.get(1), is(new Integer(3)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		mal.removeAll(list);
		assertThat(mal.size(), is(0));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		Integer val = mal.set(1, 5);
		assertThat(val, is(new Integer(2)));

		val = mal.set(0, 6);
		assertThat(val, is(new Integer(1)));

		val = mal.set(2, 7);
		assertThat(val, is(new Integer(3)));

		// return value should be 2
		// list should be [6, 5, 7]
		assertThat(mal.get(0), is(new Integer(6)));
		assertThat(mal.get(1), is(new Integer(5)));
		assertThat(mal.get(2), is(new Integer(7)));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mal.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mal.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		assertThat(mal.size(), is(3));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		mal.addAll(list);
		List<Integer> sub = mal.subList(1, 4);
		assertThat(sub.get(1), is(new Integer(3)));
	}

	/**
	 * Test method for {@link com.flatironschool.javacs.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] array = mal.toArray();
		assertThat((Integer)array[0], is(new Integer(1)));
	}

}
