import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Datto {
	int[] incrementalBackups(int lastBackupTime, int[][] changes) {
		Map<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
	    for(int[] change : changes){
	        if(tm.containsKey(change[1])){
	            tm.get(change[1]).add(change[0]);
	        } else {
	            ArrayList<Integer> timeStamps = new ArrayList<Integer>();
	            timeStamps.add(change[0]);
	            tm.put(change[1], timeStamps);
	        }
	    }
	    List<Integer> backups = new ArrayList<Integer>();
	    for(Map.Entry<Integer, ArrayList<Integer>> e : tm.entrySet()){
	        boolean needBackup = false;
	        for(int timeStamp : e.getValue()){
	            if(timeStamp > lastBackupTime){
	                needBackup = true;
	            }
	        }
	        if(needBackup){
	            backups.add(e.getKey());
	        }
	    }
	    int[] incrementalBackups = new int[backups.size()];
	    for(int i = 0; i < backups.size(); i++){
	        incrementalBackups[i] = backups.get(i);
	    }
	    return incrementalBackups;
	}
	public static void main(String args[]){
		
	}
}
