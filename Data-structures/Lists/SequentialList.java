package list;

import java.util.Iterator;

public class SequentialList<T> implements Iterable<T>{
	//array that save elements
	private T[] elements;
	//counter for quantity of elements
	private int num;
	
	//constructor
	public SequentialList(int capacity) {
		elements = (T[])new Object[capacity];
		num = 0;
	}
	
	//clear the sequenceList
	public void clear() {
		num = 0;
	}
	
	//determine whether the sequenceList is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	//get the quantity of elements
	public int length() {
		return num;
	}
	
	//read and return the value of index i
	public T get(int i) {
		if(i < 0 || i >= num) {
			throw new RuntimeException("No such elements!");
		}
		return elements[i];
	}
	
	//add element t to sequenceList
	public void insert(T t) {
		if(elements.length == num) {
			throw new RuntimeException("The sequence list is full!");
		}
		elements[num] = t;
		num++;
	}
	
	//insert an elements with value t before the elements with index i
	public void insert(int i, T t) {
		if(i < 0 || i > num) {
			throw new RuntimeException("The position is illegal!");
		}
		if(num == elements.length) {
			resize(elements.length* 2);
		}
		for(int index = num; index > i; index--) {
			elements[index] = elements[index-1];
		}
		elements[i] = t;
		num++;
	}
	
	//delete element at index i and return that element
	public T remove(int i) {
		if(i < 0 || i > num-1) {
			throw new RuntimeException("No such elements!");
		}
		T res = elements[i];
		for(int index = i; index < num-1; index++) {
			elements[index] = elements[index+1];
		}
		num--;
		
		if(num > 0 && num < elements.length / 4) {
			resize(elements.length / 2);
		}
		return res;
	}
	
	//find the index that element t the first appearance
	public int indexOf(T t) {
		if(t == null) {
			throw new RuntimeException("The element is illegal!");
		}
		for(int i = 0; i < num; i++) {
			if(elements[i] == t) {
				return i;
			}
		}
		return -1;
	}
	
	//print elements
	public void showEl() {
		for(int i = 0; i < num; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}
	
	@Override
	public Iterator iterator() {
		return new SIterator();
	}
	
	private class SIterator implements Iterator{
		private int cur;
		public SIterator() {
			this.cur = 0;
		}
		@Override
		public boolean hasNext() {
			return cur < num;
		}
		@Override
		public Object next() {
			return elements[cur++];
		}
	}
	
	private void resize(int newsize) {
		T[] temp = elements;
		elements = (T[]) new Object[newsize];
		for(int i = 0; i < num; i++) {
			elements[i] = temp[i];
		}
	}
	
	public int capacity() {
		return elements.length;
	}
}
