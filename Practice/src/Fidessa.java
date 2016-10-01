import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Fidessa {
	static boolean solution(String input){
		Stack<Character> stk = new Stack<Character>();
		char[] ar = input.toCharArray();
		stk.push(ar[0]);
		for(char c : ar){
			if(Character.isUpperCase(c)){
				stk.add(c);
			} else if(Character.isLowerCase(c)){
				Character ch = Character.toLowerCase(stk.pop());
				if(!ch.equals(c)){
					return false;
				}
			}
		}
		return true;
	}
	
	// roman numeral to decimal

	// minimum number of platforms required for a railway bus station
	static int minPlatforms(int[] arr, int[] dep){
		Event[] events = new Event[arr.length+dep.length];
		for(int i = 0; i < arr.length; i++){
			events[i] = new Event(arr[i], "Arrival");
		}
		for(int j = arr.length, k = 0; j < arr.length+dep.length; j++, k++){
			events[j] = new Event(dep[k], "Departure");
		}
		ArrayList<Event> eventsAr = new ArrayList<Event>();
		for(Event e : events){
			eventsAr.add(e);
		}
		Collections.sort(eventsAr, new TimeComparator());
		int platforms = 0;
		int min = Integer.MIN_VALUE;
		for(Event e : eventsAr){
			System.out.println("Time: "+e.time+" | Type: "+e.type);
			if(platforms > min){
				min = platforms;
			}
			if(e.type.equals("Arrival")){
				platforms++;
			} else if(e.type.equals("Departure")){
				platforms--;
			}
		}
		return min;
	}
	
	public static void main(String args[]){
		System.out.println(solution("AaBb"));
		System.out.println(solution("PQqRrp"));
		
		int[] arr = new int[]{900,940,950,1100,1500,1800};
		int[] dep = new int[]{910,1200,1120,1130,1900,2000};
		System.out.println(minPlatforms(arr, dep));
	}
}
class Event {
	int time;
	String type;
	public Event(){
	}
	public Event(int time, String type){
		this.time=time;
		this.type=type;
	}
}
class TimeComparator implements Comparator<Event>{
	public int compare(Event e1, Event e2){
		return e1.time - e2.time; 
	}
}