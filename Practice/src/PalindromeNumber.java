
public class PalindromeNumber {

	public static boolean isPalindrome(int x){
		if(x < 0) return false;
		
		int div = 1;
		while(x / div >= 10){
			div = div * 10;
		}
		System.out.println("div: "+div);
		while (x != 0) {
			System.out.println(x);
			int left = x / div;
			int right = x % 10;

			if (left != right) return false;
 
			x = (x % div) / 10; // trim both left and right sides
			div /= 100;
		}
		
		return true;
	}
	public static void main(String args[]){
		System.out.println(isPalindrome(34543));
		//System.out.println(isPalindrome(3443));
		//System.out.println(3789%1000);
	}
}
