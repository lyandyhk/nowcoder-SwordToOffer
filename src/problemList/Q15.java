package problemList;
/**
 * 
 * @author Febiven
 *��Ŀ������һ��������ת�����������������Ԫ�ء�
     
     �������õ�������ʱ�ڵ�curr��next��ͷ���s
     1����Ϊ������head���Ǵ�����ݵģ�����������ͷ���s��next����head
     2��currΪͷ�������һ���ڵ㣬nextΪcurr����һ���ڵ㣬���ˣ�ͷ����next�ſ�
     3��ѭ����ֻҪcurr���ǿսڵ�ͼ���
     4����curr�ĺ�̽ڵ�ָ��ͷ���ĺ�̽ڵ㣬ͷ�����ָ��curr����ͽ�curr�ɹ�������ͷ�����ԭ��ͷ���ĺ�̽ڵ�֮��
     5��Ȼ��next����curr����Ϊwhile����ʱcurr��Ϊ�գ������ʱΪ�գ�������curr.next���������Դ�ʱ��һ���жϣ����Ϊ��˵����ʱ�ѽ���������ѭ��
     6�������Ϊ�գ��ٽ���ʱ��curr.next����next
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