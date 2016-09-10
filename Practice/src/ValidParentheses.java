import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(map.keySet().contains(c)){
				stk.push(c);
			} else if(map.values().contains(c)){
				if(!stk.empty() && map.get(stk.peek()) == c){
					stk.pop();
				} else {
					return false;
				}
			}
		}
		return stk.empty();
    }
	public static void main(String args[]){
		System.out.println(isValid("()"));
	}
}
