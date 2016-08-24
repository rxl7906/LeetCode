import java.util.HashSet;

public class IntegerProblems {
	
	// add digits
	static int addDigits(int num) {
        while(num >= 10) {
            int sum = 0;
		    while(num > 0) {
    			int res = num % 10;
    			sum += res;
    			num /= 10;
    		}
    		num = sum;
        }

		return num;
    }
	
	static int numDigits(int n){
        int digits = 0;
        while(n > 0){
            n /= 10;
            digits++;
        }
        return digits;
    }
	static int sum(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i*i;
        }
        return sum;
    }
	static int[] getDigits(int n){
        int len = numDigits(n), i = 0;
        int[] nums = new int[len];
        while(n > 0){ 
            int ans = n % 10;
            nums[i++] = ans;
            n /= 10;
        }
		return nums;
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<Integer>();
        while(!hs.contains(n)){
            hs.add(n);
            n = sum(getDigits(n));
            if(n == 1) return true;
        }
        return false;
    }
    
    public static String parity(String msg){
    	String parityStr = null;
    	int n = msg.hashCode();
    	System.out.println(n);
    	switch(n%2)
    	{
    	case 0:
    		parityStr = "even";
    		break;
    	case 1:
    		parityStr = "odd";
    		break;
    	}
    	return parityStr;
    }

	public static void main(String args[]){
		//System.out.println(addDigits(19));
		//System.out.println(isHappy(19));
		System.out.println(parity("abc"));
	}
}
