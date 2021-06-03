package sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {4, 7, 2, 5, 11, 19, 3, 0};
		printArr(insert(numbers));
	}
	
	public static int[] insert(int[] nums) {
		int min = nums[0];
		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j-1] > nums[j]) {
					int temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = temp;
				}
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
