import java.util.HashMap;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(char c : s.toCharArray()){
			if(hm.containsKey(c)){
				hm.put(c, hm.get(c)+1);
			} else {
				hm.put(c,1);
			}
		}
		
		for(char ch : t.toCharArray()){
			if(hm.containsKey(ch)){
				if(hm.get(ch) == 1){
					hm.remove(ch);
				} else {
					hm.put(ch, hm.get(ch)-1);
				}
			}
		}
		if(hm.size() == 0){
			return true;
		}
		return false;
	}
	public static void main(String args[]){
		System.out.println(isAnagram("anagram","nagmaar"));
		System.out.println(isAnagram("rat","car"));
		System.out.println(isAnagram("a","ab"));
	}
}
