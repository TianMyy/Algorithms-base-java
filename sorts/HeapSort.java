package sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {4, 7, 2, 5, 11, 19, 3, 0};
		heapSort(numbers);
		printArr(numbers);
	}
	
	public static void heapSort(int[] nums) {
		for(int i = nums.length/2-1; i >= 0; i--){
            adjustHeap(nums, i, nums.length);
        }
		
		for(int j = nums.length-1; j > 0; j--){
			// exchange the element of head with tail
            exchange(nums, 0, j);
            // correct the position of elements
            adjustHeap(nums, 0, j);
        }		
	}
	
	 public static void adjustHeap(int []nums, int i, int length){
	     while(2*i+1 <= length-1) {
	    	 int max = 2*i+1;
	    	 if(2*(i+1) <= length-1) {
	    		 if(less(nums, max, 2*(i+1))) {
	    			 max = 2*(i+1);
	    		 }
	    	 }
	    	 
	    	 if(less(nums, i, max)) {
	    		 exchange(nums, i, max);
	    		 i = max;
	    	 }else {
	    		 break;
	    	 }
	     }
	 }
	
	public static boolean less(int[] nums, int i, int j) {
		return nums[i] < nums[j];
	}
	
	public static void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void printArr(int[] nums) {
		System.out.println("After sorting:");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
