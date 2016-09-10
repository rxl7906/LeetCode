import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
	public static String decodeString(String s) {
		Stack<Character> charStk = new Stack<Character>();
        Stack<Integer> intStk = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(Character.isDigit(c)){
        		intStk.push(Character.getNumericValue(c));
        		//System.out.println(intStk.peek());
        	}
        	if(Character.isAlphabetic(c)){ 
        		charStk.push(c);
        	}
        	
        	if(c == ']'){
        		int times = intStk.pop();
        		char ch = charStk.pop();
        		for(int j = 0; j < times; j++){
        			System.out.print(ch);
        		}
        	}
        }
		return "";
    }
	public static void main(String args[]){
		System.out.println(decodeString("3[a]2[bc]"));
	}
}
