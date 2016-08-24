import java.util.HashMap;

public class RansomNote {
	public static boolean canConstruct(String ransomNote, String magazine) {
        // create hashmap for magazine
        HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
        for(char c : magazine.toCharArray()){
        	if(hm.containsKey(c)){
        		hm.put(c, hm.get(c)+1);
        	} else {
        		hm.put(c, 1);
        	}
        }
        for(char ch : ransomNote.toCharArray()){
        	if(hm.containsKey(ch)){
        		// decrement by 1; if the count is 1 then remove
        		if(hm.get(ch) == 1){
        			hm.remove(ch);
        		} else {
        			hm.put(ch, hm.get(ch)-1);
        		}
        	} else {
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String args[]){
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}
}
