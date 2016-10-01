import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
	public static List<ArrayList<String>> groupAnagrams(String[] strs) {
		List<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        Map<String, ArrayList<String>> hm = new LinkedHashMap<String, ArrayList<String>>();
        
        for(String s : strs){
        	/*char[] str = s.toCharArray();
        	Arrays.sort(str);
        	String sortedStr = new String(str);*/
        	char[] arr = new char[26];
            for(int i=0; i<s.length(); i++){
                arr[s.charAt(i)-'a']++;
            }
            String sortedStr = new String(arr);
            //System.out.println(sortedStr);
            //System.out.println(sortedStr.);
        	if(hm.containsKey(sortedStr)){
        		hm.get(sortedStr).add(s);
        	} else {
        		ArrayList<String> ar = new ArrayList<String>();
        		ar.add(s);
        		hm.put(sortedStr, ar);
        	}
        }
        
        for(Map.Entry<String, ArrayList<String>> e : hm.entrySet()){
        	ArrayList<String> ar = e.getValue();
        	groups.add(ar);
        }
        return groups;
        
    }
	public static void main(String args[]){
		List<ArrayList<String>> groups = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
		for(ArrayList<String> group : groups){
			System.out.print("[");
			for(String s : group){
				System.out.print(s+" ");
			}
			System.out.print("]");
		}
	}
}
