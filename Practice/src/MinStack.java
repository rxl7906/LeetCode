import java.util.Stack;

public class MinStack {
	static Stack<Integer> stk1;
    static Stack<Integer> stk2;
    /** initialize your data structure here. */
    public MinStack() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }
    public static void push(int x) {
        stk1.add(x);
        if(!stk2.isEmpty()){
            if(x < stk2.peek()){
                stk2.add(x);
            }
        } else{
            stk2.add(x);
        }
    }
    
    public static void pop() {
        if(!stk1.isEmpty()){
            // pop from both if they match
            if(stk2.peek() == stk1.peek()){
                stk2.pop();
            }
            stk1.pop();
        }
    }
    
    public static int top() {
        return stk1.peek();
    }
    
    public static int getMin() {
        if(!stk2.isEmpty()){
            return stk2.peek();
        } else {
            return -1;
        }
    }
    public static void main(String args[]){
    	MinStack ms = new MinStack();
    	ms.push(-2);
    	ms.push(0);
    	ms.push(-3);
    	//System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.top());
    	ms.pop();
    	System.out.println(ms.top());
    	//System.out.println(ms.getMin());
    }
}
