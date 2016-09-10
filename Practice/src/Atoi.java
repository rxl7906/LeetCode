
public class Atoi {

	public static int myAtoi(String str) {
        if(str.length() < 1 || str == null){
            return 0;
        }
        str = str.trim();
        int i = 0;
        double res = 0;
        boolean isNegative = false;
        if(str.charAt(i) == '-'){
            isNegative = true;
            i++;
        } else if(str.charAt(i) == '+'){
            i++;
        }
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res *= 10;
            res += str.charAt(i) - '0';
            i++;
        }
        if(isNegative) res *= -1;

    	if (res > Integer.MAX_VALUE)
    		return Integer.MAX_VALUE;
     
    	if (res < Integer.MIN_VALUE)
    		return Integer.MIN_VALUE;

        return (int)res;
    }
	public static void main(String args[]){
		System.out.println(myAtoi("2147483648"));
	}
}
