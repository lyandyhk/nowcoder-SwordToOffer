package problemList;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ������һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩,
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * @author Febiven
 *
 *	ע��㣺����ʹ���κ�һ���ڵ��ԭ�������ã���Ҫ�Լ��½�һ���µĶ��󣬲�����ԭ�����������
 *	˼·��
 *		1.��������list��ѡ�������listʵ�֣�����ArrayList�������ڴ��ԭ�����λ�ú��½�����ĸ����ڵ�
 *		2.�ȸ�������һ��һ���Ĵ����½ڵ㣬��һ��ֻ����ֵ��Ҳ����label������ԭ����һ��
 *		3.��һ����list�еĶ����next��˳��һ��һ��ǰ���������������һ����next����Ҫ�����κζ���
 *		4.��һ��ѭ��ԭ�����Ӧ��list��ÿһ���ڵ��е�random��Ӧ�Ľڵ��λ���ҳ���������������ΪIndex
 *		    Ȼ����ȥ��list�У�����Ӧλ���ϵĽڵ��randomҲ���ӵ����list������ΪIndex�Ľڵ���
 *		5.������list�еĵ�һ���ڵ㣬���˳������
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
