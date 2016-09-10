import java.util.Set;
import java.util.TreeSet;

class LLNode {
	public String val;
	public LLNode next;
	public LLNode(String val){
		this.val=val;
	}
}
// Google Interview Question
public class AddLinkedLists {
	
	static int addIntegers(LLNode head, int[] indices){
		int index = 0;
		String[] strings = new String[indices.length];
		int pos = 0;
		while(head != null && index < indices.length){
			if(indices[index] == pos){
				strings[index] = head.val;
				index++;
			}
			pos++;
			head = head.next;
		}
		// convert string array to integer array
		int[] values = new int[strings.length];
		for(int i = 0; i < strings.length; i++){
			values[i] = Atoi.myAtoi(strings[i]);
		}
		int sum = 0;
		for(int i : values){
			sum += i;
		}
		return sum;
	}
	
	static void printLL(LLNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static void main(String args[]){
		LLNode head = new LLNode("392");
		head.next = new LLNode("5144");
		head.next.next = new LLNode("26");
		head.next.next.next = new LLNode("83231");
		head.next.next.next.next = new LLNode("474");
		//printLL(head);
		System.out.println(addIntegers(head, new int[]{1, 2, 3}));
		String s = "10.0% higher than in-store";
		String[] splitStr = s.split(" ");
		String[] percent = splitStr[0].split("%");
		String value = splitStr[0].split("%")[0];
		System.out.println(Double.parseDouble(value)/100*110);
		//System.out.println(splitStr[0]);
		//System.out.println(splitStr[1]);
		Set<String> ts = new TreeSet<String>();
		ts.add("Handyman");
		ts.add("Computer lessons");
		ts.add("Computer repair");
		ts.add("House cleaning");
		ts.add("Data Recovery");
		for(String str : ts){
			System.out.println(str);
		}
		
	}
}
