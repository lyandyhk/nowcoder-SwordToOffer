package problemList;
/**
 * 
 * @author Febiven
 *题目：输入一个链表，反转链表后，输出链表的所有元素。
     
     分析：用到三个临时节点curr，next和头结点s
     1。因为本题中head中是存放数据的，所以首先让头结点s的next连上head
     2。curr为头结点下面一个节点，next为curr下面一个节点，至此，头结点的next放空
     3。循环，只要curr不是空节点就继续
     4。让curr的后继节点指向头结点的后继节点，头结点再指向curr，这就将curr成功插入了头结点与原来头结点的后继节点之间
     5。然后将next传给curr，因为while条件时curr不为空，如果此时为空，则后面的curr.next将出错，所以此时做一个判断，如果为空说明此时已结束，跳出循环
     6。如果不为空，再将此时的curr.next传给next
 */


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