package heap;

public class Heap<T extends Comparable<T>> {
	private T[] items;
	private int num;
	public Heap(int capacity) {
		this.items = (T[]) new Comparable[capacity + 1];
		this.num = 0;
	}
	
	// determine whether element of index i is less than index j
	private boolean less(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}
	
	// exchange value of index i with index j
	private void exchange(int i, int j) {
		T temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	// insert an element to the heap
	public void insert(T t) {
		num++;
		items[num] = t;
		swim(num);
	}
	
	// delete the max in the heap and return the max
	public T delMax() {
		T max = items[1];
		exchange(1, num);
		items[num] = null;
		num--;
		sink(1);
		return max;
	}
	
	// swim() function to correct the position of element
	private void swim(int k) {
		while(k > 1) {
			if(less(k/2, k)) {
				exchange(k, k/2);
				k = k/2;
			}
		}
	}
	
	// sink() function to correct the position of element
	private void sink(int k) {
		// 2*k == num means at the max depth of heap, no need to sink
		while(2*k <= num) {
			int max;
			if(2*k + 1 <= num) {
				// means it has right child node
				if(less(2*k, 2*k+1)) {
					max = 2*k + 1; 
				}else {
					max = 2*k;
				}
			}else {
				max= 2*k;
			}
			if(less(k, max)) {
				exchange(k, max);
				k = max;
			}else {
				break;
			}
		}
	}
}
