import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharInString {
	public static int firstUniqChar(String s) {
		if(s == null || s.length() == 0) return -1;
		/*for(int i = 0; i < s.length(); i++){
            int j = 0;
            while(j < s.length()){
                if(i == j){
                	j++;
                    continue;
                } else {
                    if(s.charAt(i) == s.charAt(j)){ // not unique
                        break;
                    }
                    j++;
                }
            }
            if(j == s.length()){
                return i;
            }
        }
        return -1;*/
		Map<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, s.length());
            } else {
                hm.put(c, i);
            }
        }
        for(Map.Entry<Character, Integer> e : hm.entrySet()){
            if(!(e.getValue() == s.length())){
                return e.getValue();
            }
        }
        return -1;
    }
	public static void main(String args[]){
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
