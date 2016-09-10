
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = slow.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
	/*
	boolean hasLoop(Node first) {
	
	    if(first == null) // list does not exist..so no loop either.
	        return false;
	
	    Node slow, fast; // create two references.
	
	    slow = fast = first; // make both refer to the start of the list.
	
	    while(true) {
	
	        slow = slow.next;          // 1 hop.
	
	        if(fast.next != null)
	            fast = fast.next.next; // 2 hops.
	        else
	            return false;          // next node null => no loop.
	
	        if(slow == null || fast == null) // if either hits null..no loop.
	            return false;
	
	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return true;
	    }
	}
	 */
	static void printLL(Node head){
		if(head == null) return;
		
		printLL(head.next);
		
		System.out.println(head.val);
	}
	public static void main(String args[]){
		Node head = new Node(3);
		head.next = new Node(5);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		printLL(head);
	}
}
