import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntegerIntersection {
	public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<Integer>();
        Set<Integer> hs = new HashSet<Integer>();
        for(int i : nums1){
            hs.add(i);
        }
        for(int j : nums2){
            if(hs.contains(j)){
                intersection.add(j);
            }
        }
        int c = 0;
        int[] inter = new int[intersection.size()];
        for(Integer k : intersection){
            inter[c] = k;
            c++;
        }
        return inter;
    }
	public static void main(String args[]){
		int[] ar = new int[]{1};
		int[] arr = new int[]{1};
		int[] res = intersection(ar,arr);
		for(int i : res){
			System.out.println(i);
		}
	}
}
