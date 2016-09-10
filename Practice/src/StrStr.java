
public class StrStr {
	static int strStr(String haystack, String needle){
		if(haystack.length() < needle.length()){
			return -1;
		}
		if(needle.equals("")){
		    return 0;
		}
		for(int i = 0; i < haystack.length(); i++){
		    // if i+needle.length > haystack.length then it would go string out of bounds
		    if(i + needle.length() > haystack.length()) return -1;
			if(haystack.charAt(i) == needle.charAt(0)){
				int k = i;
				for(int j = 0; j < needle.length(); j++){
					if(haystack.charAt(k) == needle.charAt(j)){
					    if(j == needle.length()-1){
					        return i;
					    }
						k++;
					} else {
						break;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String args[]){
		System.out.println(strStr("The sky is blue", "sky"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("mississippi", "issi"));
	}
}
