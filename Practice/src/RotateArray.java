
public class RotateArray {
	static void rotate(int[] nums, int k){
		if(k > nums.length){
			k = k % nums.length;
		}
		
		int[] arr = new int[nums.length];
		for(int i=0; i<k; i++){
			arr[i] = nums[nums.length-k+i];
		}
		int j = 0;
		for(int i=k; i<nums.length; i++){
			arr[i] = nums[j];
			j++;
		}
		int c = 0;
		for(int i : arr){
			nums[c] = i;
			c++;
		}
	}
	public static void main(String args[]){
		int[] nums = new int[]{1,2,3,4,5,6,7};
		rotate(nums, 10);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}
}
