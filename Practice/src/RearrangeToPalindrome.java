import java.util.HashMap;
import java.util.Map;

public class RearrangeToPalindrome {

	static boolean canConvertToPalindrome(String s){
		if(s == null || s.length() == 0) return false;
		char[] ar = s.toCharArray();
		Map<Character, Integer> hm = new HashMap<Character,Integer>();
		int len = ar.length;
		boolean isEven = false;
		if(len % 2 == 0 ) isEven = true;
		for(char c : ar){
			if(hm.containsKey(c)){
				hm.put(c, hm.get(c)+1);
			} else {
				hm.put(c, 1);
			}
		}
		int c = 0;
		for(Map.Entry<Character, Integer> e : hm.entrySet()){
			if(c > 1) return false;
			if(e.getValue() % 2 == 1){
				c++;
			}
		}
		return true;
	}
	public static void main(String args[]){
		String s = "alulauuaa";
		System.out.println(canConvertToPalindrome(s));
	}
}
