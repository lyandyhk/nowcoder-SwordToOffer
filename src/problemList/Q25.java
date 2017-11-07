package problemList;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）,
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author Febiven
 *
 *	注意点：不能使用任何一个节点的原对象引用，需要自己新建一个新的对象，参数与原对象定义上相等
 *	思路：
 *		1.创建两个list（选择有序的list实现，比如ArrayList），用于存放原链表的位置和新建链表的各个节点
 *		2.先根据链表一个一个的创建新节点，这一步只创建值，也就是label保持与原链表一致
 *		3.这一步将list中的对象的next按顺序一个一个前后连接起来，最后一个的next不需要连接任何东西
 *		4.这一步循环原链表对应的list，每一个节点中的random对应的节点的位置找出来，记下来，记为Index
 *		    然后再去新list中，将对应位置上的节点的random也连接到这个list中索引为Index的节点上
 *		5.返回新list中的第一个节点，至此程序结束
 *		
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Q25 {
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null)
			return null;
        List<RandomListNode> list = new ArrayList<RandomListNode>();
        List<RandomListNode> newList = new ArrayList<RandomListNode>();
//        RandomListNode curr = pHead.next;
        while(pHead != null){
        	RandomListNode node = new RandomListNode(pHead.label);
        	list.add(pHead);
        	newList.add(node);
        	pHead = pHead.next;
        }
        for(int i=0;i<newList.size()-1;i++){
        	newList.get(i).next = newList.get(i+1);
        }
        for(int i=0;i<list.size();i++){
        	if(list.get(i).random == null)
        		continue;
        	int randomIndex = list.indexOf(list.get(i).random);
        	newList.get(i).random = newList.get(randomIndex);
        }
        return newList.get(0);
    }
}
