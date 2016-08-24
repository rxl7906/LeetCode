import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ProductofTwoIntegers {
	/*static int[] Near_Square(int n) {
	    int[] ar = new int[2];
	    ArrayList<Integer> factors = findFactors(n);
	    if(factors.size() <= 1){
	        return ar;
	    }
	    Set<Integer> hs = new TreeSet<Integer>();
	    hs.addAll(factors);
	    factors.clear();
	    factors.addAll(hs);
	    int a = factors.size()/2 - 2;
	    int b = factors.size()/2 - 1;
	    ar[0] = factors.get(a);
	    ar[1] = factors.get(b);
	    return ar;
	}*/

	static ArrayList<Integer> findFactors(int n){
	    ArrayList<Integer> factors = new ArrayList<Integer>();
	    for(int i = 1; i < n/2; i++){
	        if(n % i == 0){
	            factors.add(i);
	            factors.add(n/i);
	        }
	    }
	    return factors;
	}
	
	static int[] Near_Square(int n) {

	    int a = 1, x = 1, y = n;
			
		for (int i = 1; i < n/2; i++) {
	 
	        if(n%i == 0) {
				if(i*i == n) {
					x = i; 
					y = i;
				}	
				if(a*i == n) {
					x = a; 
					y = i;
				}
				a = i;
			}
		}
		return new int[]{x, y};
	    
	}
	public static void main(String args[]){
		int[] ar = Near_Square(120);
		for(int i : ar){
			System.out.println(i);
		}
	}
}
