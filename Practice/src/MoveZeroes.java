/*
 * Leetcode
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
	
	static void moveZeroes(int[] ar){
		int j = 0;
		for(int i = 0; i < ar.length; i++){
			if(ar[i] != 0){
				ar[j] = ar[i];
				j++;
			}
		}
		while(j < ar.length){
			ar[j] = 0;
			j++;
		}
	}
	public static void main(String args[]){
		int[] ar = new int[]{0,1,0,3,12};
		moveZeroes(ar);
		System.out.print("{");
		for(int i : ar){
			System.out.print(i + " ");
		}
		System.out.print("}");
	}
}
