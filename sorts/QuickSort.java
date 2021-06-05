package sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = {4, 7, 2, 5, 11, 19, 3, 0};
		sort(numbers);
		printArr(numbers);
	}
	
	public static void sort(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		sort(nums, left, right);
	}
	
	public static void sort(int[] nums, int left, int right) {
		if(left < right) {
			int divide = quick(nums, left, right);
			sort(nums, left, divide);
			sort(nums, divide+1, right);
		}
	}
	
	public static int quick(int[] nums, int left, int right) {
		int key = nums[left];
		int start = left;
		int end = right + 1;
		while(true) {
			while(key < nums[--end]) {
				if(end == left) {
					break;
				}
			}
			while(key >= nums[++start]) {
				if(start == right) {
					break;
				}
			}
			if(left >= right) {
				break;
			}else {
				swap(nums, start, end);
			}
		}
		swap(nums, left, end);
		return end;
	}
	
	public static void swap(int[] nums, int i, int j) {
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
