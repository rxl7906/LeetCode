
public class LongestCommonPrefix {
	static String longestCommonPrefix(String[] strs) {
        // find str with minimum length
		String minS = strs[0];
		for(String s : strs){
			if(s.length() < minS.length()){
				minS = s;
			}
		}
		//System.out.println(minS);
		
		String prefix = minS;
		for(int i = 1; i < strs.length; i++){
			
			for(int j = 0; j < prefix.length(); j++){
				if(strs[i].charAt(j) != prefix.charAt(j)){
					// get substring up from 0 to j
					prefix = strs[i].substring(0, j);
				}
			}
		}
		
		return prefix;
    }
	public static void main(String args[]){
		String[] ar = new String[]{"apple","ape","april"};
		String[] ar2 = new String[]{"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println(longestCommonPrefix(ar));
		System.out.println(longestCommonPrefix(ar2));
	}
}
