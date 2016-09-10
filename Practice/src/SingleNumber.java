import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	static int singleNumber(int[] nums) {
		Set<Integer> hs = new HashSet<Integer>();
        for(int num : nums){
            if(hs.contains(num))hs.remove(num);
            else hs.add(num); 
        }
        return hs.iterator().next();
    }
	public static void main(String args[]){
		int[] nums = new int[]{4,2,4,2,3,1,3};
		System.out.println(singleNumber(nums));
	}
}
