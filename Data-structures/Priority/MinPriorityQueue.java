package priority;

public class MinPriorityQueue<T extends Comparable<T>> {
	private T[] items;
	private int num;
	public MinPriorityQueue(int capacity) {
		this.items = (T[]) new Comparable[capacity+1];
		this.num = 0;
	}
	
	//get size
	public int size() {
		return num;
	}
	
	// determine empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// determine whether items[i] < items[j]
	private boolean less(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}
	
	// exchange position of items[i] and items[j]
	private void exchange(int i, int j) {
		T temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	// insert an elemnt
	public void insert(T t) {
		num++;
		items[num] = t;
		swim(num);
	}
	
	// delete min element and return
	public T delMin() {
		T min = items[1];
		exchange(1, num);
		num--;
		sink(1);
		return min;
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
				exchange(min, k);
				k = min;
			}else {
				break;
			}
		}
	}
}
