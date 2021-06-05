package sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] numbers = {4, 7, 2, 5, 11, 19, 3, 0};
		sort(numbers);
		printArr(numbers);
	}
	
	public static void sort(int[] nums) {
		int[] temp = new int[nums.length];
		sort(nums, 0, nums.length-1, temp);
	}
	
	public static void sort(int[] nums, int start, int end, int[] temp) {
		if(start < end) {
			int mid = (start + end) / 2;
			sort(nums, start, mid, temp);
			sort(nums, mid+1, end, temp);
			merge(nums, start, mid, end, temp);
		}
	}
	
	public static void merge(int[] nums, int start, int mid, int end, int[] temp) {
		int p1 = start;
		int p2 = mid+1;
		int pTemp = 0;
		while(p1 <= mid && p2 <= end) {
			if(nums[p1] < nums[p2]) {
				temp[pTemp++] = nums[p1++];
			}else {
				temp[pTemp++] = nums[p2++];
			}
		}
		while(p1 <= mid) {
			temp[pTemp++] = nums[p1++];
		}
		while(p2 <= end) {
			temp[pTemp++] = nums[p2++];
		}
//		for(int i = start; i <= end; i++) {
//			nums[i] = temp[i];
//		}
		pTemp = 0;
        //将temp中的元素全部拷贝到原数组中
        while(start <= end){
            nums[start++] = temp[pTemp++];
        }
	}
	
	public static void printArr(int[] nums) {
		System.out.println("After sorting:");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
