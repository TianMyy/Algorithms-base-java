package priority;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
	// store items in heap
	private T[] items;
	// store indexes of items in heap
	private int[] pq;
	// value of pq as index, index of pq as value
	private int[] reversepq;
	private int num;
	public IndexMinPriorityQueue(int capacity) {
		this.items = (T[]) new Comparable[capacity+1];
		pq = new int[capacity+1];
		reversepq = new int[capacity+1];
		this.num = 0;
		for(int i = 0; i < reversepq.length; i++) {
			// default situation, reversepq don't store any index
			reversepq[i] = -1;
		}
	}
	
	// get size 
	public int size() {
		return num;
	}
	
	// determine if is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// determine if element at index i less than index j
	private boolean less(int i, int j) {
		// use pq to find index
		return items[pq[i]].compareTo(items[pq[j]]) < 0;
	}
	
	// exchange position
	private void exchange(int i, int j) {
		// first exchange index in pq
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		
		// update index in reversepq
		reversepq[pq[i]] = i;
		reversepq[pq[j]] = j;
	}
	
	// determine whether k pointed element exist
	public boolean contains(int k) {
		return reversepq[k] != -1;
	}
	
	// index of min element
	public int minIndex() {
		return pq[1];
	}
	
	// insert an element and related to index i
	public void insert(int i, T t) {
		if(contains(i)) {
			return;
		}
		num++;
		items[i] = t;
		pq[num] = i;
		reversepq[i] = num;
		swim(num);
	}
	
	// delete min element and return related index
	public int delMin() {
		// get related index of minimum
		int minIndex = pq[1];
		// exchange element at 1 with tail
		exchange(1, num);
		// delete reversepq
		reversepq[pq[num]] = -1;
		pq[num] = -1;
		items[minIndex] = null;
		num--;
		sink(1);
		return minIndex;
	}
	
	// delete element is related to index i
	public void delete(int i) {
		// find index of i in pq
		int k = reversepq[i];
		exchange(k, num);
		reversepq[pq[num]] = -1;
		pq[num] = -1;
		items[k] = null;
		num--;
		sink(k);
		swim(k);
	}
	
	// update value of element related to index x as t
	public void changeItem(int i, T t) {
		items[i] = t;
		int k = reversepq[i];
		sink(k);
		swim(k);
	}
	
	// swim() function
	private void swim(int k) {
		while(k > 1) {
			if(less(k, k/2)) {
				exchange(k, k/2);
			}
			k /= 2;
		}
	}
	
	// sink() function
	private void sink(int k) {
		while(2*k <= num) {
			int min = 2*k;
			if(2*k+1 <= num) {
				if(less(2*k+1, 2*k)) {
					min = 2*k+1;
				}
			}
			if(less(min, k)) {
				exchange(k, min);
				k = min;
			}else {
				break;
			}
		}
	}
}
