/**
 * 
 */
package com.flatironschool.javacs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author downey
 * @param <E>: Type of the elements in the List.
 *
 */
public class MyArrayList<E> implements List<E> {
	int size;                    // keeps track of the number of elements
	private E[] array;           // stores the elements
	
	/**
	 * 
	 */
	public MyArrayList() {
		// You can't instantiate an array of T[], but you can instantiate an
		// array of Object and then typecast it.  Details at
		// http://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
		array = (E[]) new Object[10];
		size = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// run a few simple tests
		MyArrayList<Integer> mal = new MyArrayList<Integer>();
		mal.add(1);
		mal.add(2);
		mal.add(3);
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
		
		mal.remove(new Integer(2));
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
	}

	public boolean add(E element) {
		if (size >= array.length) {
			// make a bigger array and copy over the elements
			E[] bigger = (E[]) new Object[array.length * 2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		} 
		array[size] = element;
		size++;
		return true;
	}

	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// TODO: fill in the rest of this method
		if (this.array[index] == null) {
			this.array[index] = element;
			size++;
		} else {
			this.add(this.array[this.size-1]);
			for (int i=this.size-2; i > index; i--) {
				this.array[i] = this.array[i-1];
			}
			this.array[index] = element;
		}
	}

	public boolean addAll(Collection<? extends E> collection) {
		boolean flag = true;
		for (E element: collection) {
			flag &= add(element);
		}
		return flag;
	}

	public boolean addAll(int index, Collection<? extends E> collection) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		// note: this version does not actually null out the references
		// in the array, so it might delay garbage collection.
		size = 0;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	public boolean containsAll(Collection<?> collection) {
		for (Object element: collection) {
			if (!contains(element)) {
				return false;
			}
		}
		return true;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	public int indexOf(Object target) {
		// TODO: fill in this method
		for (int i=0; i<this.size; i++) {
			if (this.equals(target, this.array[i])) {
				return i;
			}
		}
		return -1;
	}

	/** Checks whether an element of the array is the target.
	 * 
	 * Handles the special case that the target is null.
	 * 
	 * @param target
	 * @param object
	 */
	private boolean equals(Object target, Object element) {
		if (target == null) {
			return element == null;
		} else {
			return target.equals(element);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<E> iterator() {
		// make a copy of the array
		E[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).iterator();
	}

	public int lastIndexOf(Object target) {
		// see notes on indexOf
		for (int i = size-1; i>=0; i--) {
			if (equals(target, array[i])) {
				return i;
			}
		}
		return -1;
	}

	public ListIterator<E> listIterator() {
		// make a copy of the array
		E[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		// make a copy of the array
		E[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).listIterator(index);
	}

	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	public E remove(int index) {
		// TODO: fill in this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removedElement = this.get(index);
		
		if (index == this.size-1) {
			this.array[index] = null;
		} else {
			for (int i=index; i<this.size-1; i++) {
				this.array[index] = this.array[index+1];
			}
			this.array[this.size-1] = null;
		}
		this.size--;
		return removedElement;
	}

	public boolean removeAll(Collection<?> collection) {
		boolean flag = true;
		for (Object obj: collection) {
			flag &= remove(obj);
		}
		return flag;
	}

	public boolean retainAll(Collection<?> collection) {
		throw new UnsupportedOperationException();
	}

	public E set(int index, E element) {
		// TODO: fill in this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E previous = this.get(index);
		this.array[index] = element;
		return previous;
	}

	public int size() {
		return size;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		E[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
		return Arrays.asList(copy);
	}

	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	public <T> T[] toArray(T[] array) {
		throw new UnsupportedOperationException();		
	}
}
