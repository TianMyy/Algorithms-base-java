package sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {4, 7, 2, 5, 11, 19, 3, 0};
		printArr(shell(numbers));
	}
	
	public static int[] shell(int[] nums) {
		int h = 1;
		while(h < nums.length) {
			h = 2*h + 1;
		}
		for(h = h/2; h >= 1; h /= 2) {
			for(int i = h; i < nums.length; i++) {
				for(int j = i; j >= h; j -= h) {
					if(nums[j-h] > nums[j]) {
						int temp = nums[j];
						nums[j] = nums[j-h];
						nums[j-h] = temp;
					}
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
