
public class ReverseInteger {
	public static int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x *= -1;
        }
        int res = 0;
        while(x > 0){
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if(isNegative){
            res *= -1;
        }
        return res;
    }
	public static void main(String args[]){
		System.out.println(reverse(-123456));
	}
}
