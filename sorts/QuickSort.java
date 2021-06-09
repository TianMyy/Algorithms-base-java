package sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = {4, 7, 2, 5, 11, 19, 3, 0};
		printArr(quickSort(numbers, 0, numbers.length-1));
	}
	
	public static int[] quickSort(int[] nums, int left, int right) {
		if(left > right) {
			return nums;
		}
		
		int key = nums[left];
		int i = left;
		int j = right;
		while(i < j) {
			while(i < j && nums[j] > key) {
				j--;
			}
			if(i < j) {
				nums[i++] = nums[j];
			}
			while(i < j && nums[i] < key) {
				i++;
			}
			if(i < j) {
				nums[j--]= nums[i];
			}
		}
		nums[i] = key;
		nums = quickSort(nums, left, i-1);
		nums = quickSort(nums, j+1, right);
		return nums;
	}
	
	public static void printArr(int[] nums) {
		System.out.println("After sorting:");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
