import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> lst = new ArrayList<Integer>();
        if(k == 0) return lst;
        
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : nums){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
        	System.out.println("Key: "+e.getKey()+" |Value: "+e.getValue());
        }

        while(k > 0){
            int maxKey = 0;
            int maxCount = 0;
            for(Map.Entry<Integer, Integer> e : hm.entrySet()){
                if(e.getValue() > maxCount){
                    maxCount = e.getValue();
                    maxKey = e.getKey();
                }
            }
            hm.remove(maxKey);
        	lst.add(maxKey);
        	k--;
        }
        return lst;
    }
	public static void main(String args[]){
		//int[] nums = new int[]{1,1,1,2,2,3};
		//int[] nums = new int[] {4,1,-1,2,-1,2,3};
		int[] nums = new int[] {3,0,1,0};
		int k = 1;
		ArrayList<Integer> ar = (ArrayList<Integer>) topKFrequent(nums,k);
		for(int i : ar){
			System.out.println(i);
		}
	}
}
