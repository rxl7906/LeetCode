import java.util.HashSet;

public class StringProblems {
	static String stringCompression(String s){
		int start = 0;
		int c = 0;
		String str = "";
		char[] ar = s.toCharArray();
		for(int i = 0; i < s.length(); i++){
			if(ar[start] == s.charAt(i)){
				c++;
			} else {
				str = str + ar[start] + (char) c;
				c = 0;
				start = i+1;
			}
		}
		return str;
	}
	
	static String reverseString(String s) {
        char[] ar = s.toCharArray();
        int j = ar.length-1;
        for(int i = 0; i < ar.length/2; i++, j--){
            swap(ar, i, j);
        }
        String str = new String(ar);
        return str;
    }
	
    static void swap(char[] ar, int i, int j){
        char tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
    
    public static String reverseVowels(String s) {
        char[] vowels = new char[]{'a','e','i','o','u','A','E','O','I','U'};
    	HashSet<Character> hs = new HashSet<Character>();
    	for(char c : vowels){
    		hs.add(c);
    	}
        int left = 0, right = s.length()-1;
        char[] ar = s.toCharArray();
        while (left < right){
            while(left < right && (!hs.contains(ar[left]))){
                left++;
            }
            while(left < right && (!hs.contains(ar[right]))){
                right--;
            }
        	swap(ar, left, right);
            left++;
            right--;
        }
        return new String(ar);
    }
    
	public static void main(String args[]){
		String s = "aabcccccaaa";
		System.out.println(stringCompression(s));
		//System.out.println(reverseVowels("hello"));
		int a = 3;
		int b = 4;
		//System.out.println(a << 1);
		//System.out.println(1%10);
	}
}
