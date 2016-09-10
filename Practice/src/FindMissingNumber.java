
public class FindMissingNumber {

	static int findMissingNum(int[] nums){
		int j = 0, i = nums[0], len = nums.length-1;
		while(i < nums[len]){
			//System.out.println("nums[j]: "+nums[j]+" | i: "+i);
			if(nums[j++] != i){
				return i;
			}
			i++;
		}
		return i;
	}
	public static void main(String args[]){
		int[] nums = new int[]{4,5,6,8,9,10};
		System.out.println(findMissingNum(nums));
	}
}
