
public class ValidPalindrome {
	static boolean isPalindrome(String s) {
		if(s == "") return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(Character.isLetterOrDigit(c)){
        		sb.append(c);
        	}
        }
        s = sb.toString();
        char[] ar = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
        	ar[i] = s.charAt(i);
        }
        for(int i = 0; i < ar.length; i++){
        	if(!(ar[i] == ar[ar.length - 1 - i])){
        		return false;
        	}
        }
		return true;
    }
	public static void main(String args[]){
		System.out.println(isPalindrome("Ra,c,e  c ar"));
		System.out.println(isPalindrome("A ,  , nn a"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
}
