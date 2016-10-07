import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutation {
	public static Set<String> ar = new LinkedHashSet<String>();
	public static String origStr;
	public static int count = 0;
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	public static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	ar.add(prefix);
	    } else {
	        for (int i = 0; i < n; i++){
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	
	public static int findRank(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		//System.out.println(String.copyValueOf(arr));
		origStr = str;
		permutation(String.copyValueOf(arr));
		System.out.println(count);
		
		int c = 0;
		for(String s : ar){
			if(s.equals(str)){
				return c;
			}
			System.out.println(s);
			c++;
		}
		return -1;
	}
	public static void main(String args[]){
		String str = "caabbc";
		System.out.println(findRank(str));
		int c = 0;
		for(String s : ar){
			if(s.equals(str)){
				break;
			}
			System.out.println(s);
			c++;
		}
		System.out.println(c);
	}
}
