package problemList;
/**
 * 层次遍历，从上到下，从做到右遍历一棵树
 * 
 * 思路：利用队列，拿出队列的首节点，分解成左右节点插入队尾，拿出来的节点的值放入list中
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