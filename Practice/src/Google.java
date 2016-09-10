import java.util.ArrayList;
import java.util.Collections;

public class Google {
	
	public static int intArrToInteger(int[] ar){
		StringBuilder strNum = new StringBuilder();
		for (int num : ar) {
		     strNum.append(num);
		}
		int finalInt = Integer.parseInt(strNum.toString());
		return finalInt;
	}
	
	public static int[] convertIntegers(ArrayList<Integer> ar){
		int[] ret = new int[ar.size()];
	    for (int i=0; i < ret.length; i++){
	        ret[i] = ar.get(i).intValue();
	    }
	    return ret;
	}
	
	static ArrayList<Integer> getIntArr(int x){
		ArrayList<Integer> arr = new ArrayList<Integer>();
        while(x > 0){
        	arr.add(x%10);
            x /= 10;
        }
        Collections.reverse(arr);
        return arr;
	}
	
	static int solution(int x){
		ArrayList<Integer> results = new ArrayList<Integer>();

        // two pointers
        ArrayList<Integer> orig = getIntArr(x);
        int i = 0;
        int j = 1;
        while(j < orig.size()){
        	//System.out.println(orig);
        	ArrayList<Integer> tmp1 = new ArrayList<Integer>(getIntArr(x));
        	ArrayList<Integer> tmp2 = new ArrayList<Integer>(getIntArr(x));
        	// remove first
        	tmp1.remove(i);
        	int val1 = intArrToInteger(convertIntegers(tmp1));
        	// remove second
        	tmp2.remove(j);
        	int val2 = intArrToInteger(convertIntegers(tmp2));
        	//System.out.println(val1);
        	//System.out.println(val2);
        	if(val1 < val2){
        		results.add(val2);
        	} else {
        		results.add(val2);
        	}
        	i++;
        	j++;
        	
        }
        int min = Integer.MAX_VALUE;
        for(int a : results){
        	//System.out.println(a);
        	if(min > a){
        		min = a;
        	}
        }
        //System.out.println("MIN: " +min);

        return min;
	}
	
	public static void main(String args[]){
		System.out.println(solution(233614));
	}
}
