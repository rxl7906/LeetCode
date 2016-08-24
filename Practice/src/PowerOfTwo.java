
public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
        while(n >= 2){
            int mod = n % 2;
            if(n == 2){
            	return true;
            }
            n = n / 2;
            System.out.println(n);
        }
        return false;
    }
	public static void main(String args[]){
		System.out.println(isPowerOfTwo(5));
	}
}
