
public class CountPrimes {
	// Prime has factors 1 and itself
    // if able to mod 
    static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
        	if(n % i == 0) return false;
        }
    	return true;
    }
    static int countPrimes(int n) {
        // check numbers 2 to n
        int c = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)) c++;
        }
        return c;
    }
	public static void main(String args[]){
		System.out.println(countPrimes(5));
	}
}
