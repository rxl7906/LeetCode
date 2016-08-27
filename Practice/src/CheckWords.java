import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckWords {
	/*
	 * Complete the function below.
	 *
	 * k = allowance of characters that are not on the same row
	 *
	 * "alaska" "alaskan" k = 1
	 * "task" "tasksz"
	 */
	static String[] checkWords(String[] phrases, int k) {
	    ArrayList<String> results = new ArrayList<String>();
	    char[] row1 = {'q', 'w', 'e', 'r', 't', 'y','u','i','o','p'};
	    char[] row2 = {'a', 's','d','f','g','h','j','k','l'};
	    char[] row3 = {'z','x','c','v','b','n','m'};
	    Set<Character> row1Set = new HashSet<Character>();
	    Set<Character> row2Set = new HashSet<Character>();
	    Set<Character> row3Set = new HashSet<Character>();
	    for(char c : row1) row1Set.add(c);
	    for(char ch : row2) row2Set.add(ch);
	    for(char cha : row3) row3Set.add(cha);
	    for(String s : phrases){
	        String tmpstr = s;
	        if (s.length() > 0){
	            s = s.toLowerCase();
	        } else {
	            continue;
	        }
	        Set<Character> row = null;
	        char firstChar = s.charAt(0);
	        if (row1Set.contains(firstChar)){
	            row = row1Set;
	        } else if (row2Set.contains(firstChar)){
	            row = row2Set;
	        } else if (row3Set.contains(firstChar)){
	            row = row3Set;
	        }
	        
	        boolean isValid = true;
	        Set<Character> phrase = new HashSet<Character>();
	        for(int i = 0; i < s.length(); i++){
	            phrase.add(s.charAt(i));
	        }
	        
	        for(char c : phrase){
	            if(!row.contains(c)){
	                isValid = false;
	                break;
	            }
	        }
	        if (isValid) results.add(tmpstr);
	   }
	   String[] resultArray = results.toArray(new String[results.size()]);
	   return resultArray;
	}
	
	public static void main(String args[]){
		
	}
}
