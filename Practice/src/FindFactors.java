import java.util.ArrayList;

public class FindFactors {
	
	static ArrayList<Integer> findFactors(int n){
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++){
			if(n % i == 0){
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static void main(String args[]){
		ArrayList<Integer> factors = findFactors(10);
		System.out.print("{");
		for(Integer i : factors){
			System.out.print(i+" ");
		}
		System.out.print("}");
	}
}
