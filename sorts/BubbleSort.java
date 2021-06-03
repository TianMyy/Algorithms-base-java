package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {4, 7, 2, 5, 11, 19, 3, 0};
		printArr(bubble(numbers));
	}
	
	public static int[] bubble(int[] nums) {
		int length = nums.length;
		for(int i = 1; i < length; i++) {
//			for(int j = length - i; j > 0; j--) {
			for(int j = 0; j < length - i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
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
