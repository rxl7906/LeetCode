import java.util.Set;
import java.util.TreeSet;

public class ThumbTack {

	static String[][][] proCategorization(String[] pros, String[][] preferences) {
		Set<String> ts = new TreeSet<String>();
	    for(int i = 0; i < preferences.length; i++){
	        for(String s : preferences[i]){
	            ts.add(s);
	        }
	    }
	    String[][][] proList = new String[ts.size()][2][pros.length];
	    int i = 0;
	    for(String s : ts){
	        // add the category
	        proList[i][0][0] = s; // s= cateogry
	        //System.out.println(proList[i][0][0].getClass());
	        // find names with the category
	        // go thru preferences[i]; for each category
	        for(String[] proPref : preferences){
	        	int j = 0;
	        	for(String pref : proPref){
	        		if(pref.equals(s)){
		                proList[i][1][j] = pros[j];
		                j++;
		            }
	        	}
	        }
	        i++;
	    }
	    return proList;
	}
	public static void main(String args[]){
		String[] pros = new String[]{"Jack", "Leon", "Maria"};
		String[][] preferences = new String[][]{
			{"Computer repair", "Handyman", "House cleaning"},
			{"Computer lessons", "Computer repair", "Data recovery service"},
			{"Computer lessons", "House cleaning"}
		};
		String[][][] res = proCategorization(pros, preferences);
		System.out.print("[");
		for(String[][] ar : res){
			System.out.print("[");
			for(String[] str : ar){
				System.out.print("[");
				for(String s : str){
					System.out.print(s + " ");
				}
				System.out.print("]");
			}
			System.out.print("]");
		}
		System.out.print("]");
	}
}
