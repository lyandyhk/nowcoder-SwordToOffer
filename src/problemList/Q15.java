package problemList;

public class Q15 {
	public ListNode ReverseList(ListNode head) {
		ListNode s = new ListNode(0);
		s.next = head;
		ListNode curr,next;
		curr = s.next;
		next = curr.next;
		s.next = null;
		while(curr != null){
			curr.next = s.next;
			s.next = curr;
			curr = next;
			if(curr == null)
				break;
			next = curr.next;
		}
		return s.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		Q15 q = new Q15();
		ListNode result = q.ReverseList(head);
	}
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}