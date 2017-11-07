package problemList;
/**
 * ��α��������ϵ��£��������ұ���һ����
 * 
 * ˼·�����ö��У��ó����е��׽ڵ㣬�ֽ�����ҽڵ�����β���ó����Ľڵ��ֵ����list��
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q22 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode1 root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
        	return list;
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        queue.offer(root);
        while(queue.size()>0){
        	TreeNode1 node = queue.poll();
        	if(node.left != null)
        		queue.offer(node.left);
        	if(node.right != null)
        		queue.offer(node.right);
        	list.add(node.val);
        }
        return list;
    }
}
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }
}