package heap;

public class HeapSort {
	// ascend sort variables in array
	public static void sort(Comparable[] source) {
		// 1.create an array with source.length + 1
		Comparable[] heap = new Comparable[source.length + 1];
		// 2.initiate the heap
		createHeap(source, heap);
		// 3.heap sort
			// define a val to record the max index of unsorted heap array;
		int num = heap.length - 1;
		while(num != 1) {
			exchange(heap, 1, num);
			num--;
			sink(heap, 1, num);
		}
		// 4.vals in heap array are sorted, copy to source
		System.arraycopy(heap, 1, source, 0, source.length);
	}
	
	// initiate the heap based on source array
	private static void createHeap(Comparable[] source, Comparable[] heap) {
		// 1.copy the variables from source to heap
		System.arraycopy(source, 0, heap, 1, source.length);
		// 2.back recurse from 1/2 of heap index, and sink each variable
		for(int i = (heap.length-1)/2; i > 0; i--) {
			sink(heap, i, heap.length-1);
		}
	}
	
	// determine whether variable in index i less than variable in index j in heap
	private static boolean less(Comparable[] heap, int i, int j) {
		return heap[i].compareTo(heap[j]) < 0;
	}
	
	// exchange the value of index i and index j in heap
	private static void exchange(Comparable[] heap, int i, int j) {
		Comparable temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//sink() the element in target index in heap, range is 0 to given range
	private static void sink(Comparable[] heap, int target, int range) {
		while(2*target <= range) {
			int max = 2*target;
			if(2*target + 1 <= range) {
				if(less(heap, 2*target, 2*target + 1)) {
					max = 2*target + 1;
				}
			}
			
			if(less(heap, target, max)) {
				exchange(heap, target, max);
				target = max;
			}else {
				break;
			}
		}
	}
}
