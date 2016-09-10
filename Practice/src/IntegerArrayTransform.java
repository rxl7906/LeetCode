import java.util.Arrays;

public class IntegerArrayTransform {
	/*
	 * Do not edit class definition.
	 * Please note that any user-defined classes should not be declared public, private, or protected.
	 * [ 1 2 3 4 5 6 7 8]
	 */
	    
	/*
	 * Complete the function below.
	 */
	    public int[] transform(int[] array) {
	        if(array.length == 2){
	            int[] thing = {1, 2};
	            return thing;
	        } else {
	            int n = 0;
	            int len = array.length;
	            while(len > 1){
	                len = len / 2;
	                n++;
	            }
	            int[] paramArr = Arrays.copyOfRange(array, 0, array.length/2);
	            paramArr = transform(paramArr);
	            int j = 0;
	            for(int i = 0; i < array.length; i+=2){
	                array[i] = paramArr[j];
	                j++;
	            }
	            int jump = (int)Math.pow(2, n-1);
	            for(int k = 1; k < array.length; k+=2){
	                array[k] = array[k-1] + jump;
	            }
	        }
	        return array;
	    }
}
