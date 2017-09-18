package problemList;

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
