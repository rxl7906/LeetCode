
public class isStrobogrammatic {
	static boolean isValid(char c, char b) {
        switch (c) {
            case '1':
                return b == '1';
            case '6':
                return b == '9';
            case '9':
                return b == '6';
            case '8':
                return b == '8';
            case '0':
                return b == '0';
            default:
                return false;
        }
    }
	static boolean isStrobogrammatic(String s){
		char[] ar = s.toCharArray();
		int left = 0;
		int right = ar.length-1;
		for(int i = 0; i < ar.length; i++){
			if(!isValid(ar[left], ar[right])){
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		System.out.println(isStrobogrammatic("6161919"));
	}
}
