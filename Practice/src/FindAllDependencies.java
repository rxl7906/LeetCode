import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindAllDependencies {
	public static Map<String, ArrayList<String>> dependencyList = new HashMap<String, ArrayList<String>>();
	public FindAllDependencies(){
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("bar");
		dependencyList.put("foo", ar);
		
		ArrayList<String> ar1 = new ArrayList<String>();
		ar1.add("tree");
		dependencyList.put("bar", ar1);
		
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.add("car");
		ar2.add("pool");
		dependencyList.put("crib", ar2);
		
		ArrayList<String> ar3 = new ArrayList<String>();
		ar3.add("bar");
		dependencyList.put("car", ar3);
	}

	public static void main(String args[]){
		FindAllDependencies fad = new FindAllDependencies();
		ArrayList<String> result = findDependencies("crib");
		System.out.println("Result");
		for(String s : result){
			System.out.println(s);
		}
	}
	public static ArrayList<String> findDependencies(String inputDependency){
	    if(inputDependency == null || inputDependency.length() == 0){
	           throw new IllegalArgumentException("Invalid argument");
	    }
	    Queue<String> queue = new LinkedList<String>();
	    ArrayList<String> dependencies = new ArrayList<String>();
	    HashSet<String> processedList = new HashSet<String>();

	    queue.add(inputDependency);
	    while(!queue.isEmpty()){
	    	String dep = queue.poll();
	    	if(!processedList.contains(dep)){
	    		if(dependencyList.containsKey(dep)){
		    		ArrayList<String> values = dependencyList.get(dep);
		    		for(String dependency : values){
	    				dependencies.add(dependency);
		    			queue.add(dependency);
		    		}
		    	}
	    	}
	    	processedList.add(dep);
	    }
	    return dependencies;
	}
}
