import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedListPalindrome {
	static void printLinkedList(ListNode head){
		while(head!=null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	static boolean isPalindrome(ListNode head) {
		// reverse linked list
		ListNode prev = null;
		ListNode cur = head;
		ListNode next;
		while(cur!=null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		printLinkedList(prev);
		// iterate thru both lists
		ListNode curr = head;
		printLinkedList(curr);
		while(curr != null){
			if(curr.val != prev.val){
				return false;
			}
			curr = curr.next;
			prev = prev.next;
		}
		return true;
    }
	
	public static void main(String args[]){
		/*ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		System.out.println(isPalindrome(head));
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(5);
		System.out.println(isPalindrome(head2));
		ListNode head3 = new ListNode(5);
		head3.next = new ListNode(4);
		head3.next.next = new ListNode(3);
		head3.next.next.next = new ListNode(2);
		System.out.println(isPalindrome(head3));*/
		ListNode head4 = new ListNode(1);
		head4.next = new ListNode(1);
		head4.next.next = new ListNode(2);
		head4.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head4));
	}
}
