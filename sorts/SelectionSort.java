package sort;

// select the min value for each loop and exchange the value of first index in this loop with the min value
public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {4, 7, 2, 5, 11, 19, 3, 0};
		printArr(select(numbers));
	}
	
	public static int[] select(int[] nums) {
		for(int i = 0; i < nums.length-1; i++) {
			int min = i;
			for(int j = i+1; j < nums.length; j++) {
				if(nums[j] < nums[min]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
			}
		}
		return nums;
	}
	
	public static void printArr(int[] nums) {
		System.out.println("After sorting:");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}


