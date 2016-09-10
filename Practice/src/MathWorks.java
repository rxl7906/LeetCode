import java.util.Arrays;

public class MathWorks {
	public static int[] transform(int[] array) {
		if (array.length == 2) {
		    int[] ar = {1, 2};
		    return ar;
		} else {
		    int n = 0;
		    int len = array.length;
		    while (len > 1) {
				n++;
				len = len/2;
		    }

		    int[] arr = Arrays.copyOfRange(array, 0, array.length/2);
		    arr = transform(arr);
		    int j = 0;
		    for(int i = 0; i < array.length; i+=2) {
				array[i] = arr[j];
				j++;
		    }
		    int jump = (int)Math.pow(2, n-1);
		    for (int i = 1; i < array.length; i+=2) {
		    	array[i] = array[i-1] + jump;
		    }
		}
		return array;
	    }

	    public static void main(String[] args) {

			int[] ar = transform(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
			for(int i : ar) {
			    System.out.println(i);
			}
	    }
}
