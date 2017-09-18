package problemList;

/*
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 分析：
 * 1.首先，如果两个链表任意一个为空，那么直接返回另一个
 * 2.如果都不为空，那么新建一个新链表，做插入循环，链表1当前元素与链表2当前元素做大小比较，小的插入新链表，并向下进一个节点
 * 3.当两个链表中某个链表没了，为空了，那么循环结束，找出已空的链表，把另一个链表剩余节点直接拼接上新链表，程序结束
 * 	
 */

public class Q16 {
	public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
        	return list2;
        if(list2 == null)
        	return list1;
        ListNode newList = new ListNode(0);
        ListNode head = newList;
        while(list1 != null && list2 != null){
        	if(list1.val<list2.val){
        		newList.next = list1;
        		newList = newList.next;
        		list1 = list1.next;        		
        	}
        	else{
        		newList.next = list2;
        		newList = newList.next;
        		list2 = list2.next;
        	}
        }
        if(list1 == null)
        	newList.next = list2;
        else
        	newList.next = list1;
        return 
        	head.next;
        
    }
}
