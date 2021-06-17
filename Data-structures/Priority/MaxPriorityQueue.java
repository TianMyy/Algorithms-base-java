package priority;

public class MaxPriorityQueue<T extends Comparable<T>> {
	private T[] items;
	private int num;
	public MaxPriorityQueue(int capacity) {
		this.items = (T[]) new Comparable[capacity+1];
		this.num = 0;
	}
	
	// get number of elements in it
	public int size() {
		return num;
	}
	
	// determine if the queue is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// determine whether the element of index i less than element at index j
	private boolean less(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}
	
	// exchange element of index i with index j
	private void exchange(int i, int j) {
		T temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	//insert an element into it
	public void insert(T t) {
		num++;
		items[num] = t;
		swim(num);
	}
	
	//  delete max element in heap and return it
	public T delMax() {
		T max = items[1];
		exchange(1, num);
		num--;
		sink(1);
		return max;
	}
	
	// swim() funtion to correct the position of element
	private void swim(int k) {
		while(k > 1) {
			if(less(k/2, k)) {
				exchange(k/2, k);
			}
			k /= 2;
		}
	}
	
	// sink() funtion to correct the position of element
	private void sink(int k) {
		while(2*k <= num) {
			int max = 2*k;
			if(2*k + 1 <= num) {
				if(less(2*k, 2*k+1)) {
					max = 2*k+1;
				}
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
