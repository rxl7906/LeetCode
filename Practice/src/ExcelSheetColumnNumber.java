
public class ExcelSheetColumnNumber {

	static int titleToNumber(String s) {
        if(s == null || s.length() < 1){
        	throw new IllegalArgumentException("Invalid input");
        }
        int result = 0;
        int i = s.length()-1;
        int t = 0;
        while(i >= 0){
            char curr = s.charAt(i);
            result = result + (int) Math.pow(26, t) * (curr-'A'+1);
            System.out.println(result);
            t++;
            i--;
        }
		return result;
    }
	
	public static void main(String args[]){
		//System.out.println((int)'Z' - '@');
		System.out.println(titleToNumber("AA"));
	}
}
