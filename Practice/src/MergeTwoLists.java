class ListNode{
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}
public class MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				head = l1;
			} else {
				head = l2;
			}
			head = head.next;
		}
		if(l1 != null){
			while(l1!=null){
				head = l1;
				head = head.next;
			}
		}
		if(l2 != null){
			while(l2!=null){
				head = l2;
				head = head.next;
			}
		}
		return head;
    }
	
	public static void main(String args[]){
		
	}
}
