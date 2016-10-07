import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutation {
	public static Set<String> ar = new LinkedHashSet<String>();
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	public static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	ar.add(prefix);
	    	//System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	public static Set<String> crunchifyPermutation(String str) {
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = crunchifyPermutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				crunchifyResult.add(crunchifyCharAdd(newString, firstChar, i));
			}
		}
		return crunchifyResult;
	}
 
	public static String crunchifyCharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
	
	public static int findRank(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		//System.out.println(String.copyValueOf(arr));
		permutation(String.copyValueOf(arr));
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
	}
}
