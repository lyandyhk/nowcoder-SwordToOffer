package problemList;

import java.util.ArrayList;
import java.util.List;


/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author Febiven
 *
 *	
 *	输入：二叉搜索树根节点
 *	输出：所有节点排好序，并且是从左向右，从右向左的双向链表，将左右子树引用变成左右节点的引用
 *	注意：不能创建新的节点
 *	思路：通过中序遍历把节点放入一个有序列表中，再从左到右，从右到左连接起来，返回第一个root节点即可
 */

class TreeNode26 {
    int val = 0;
    TreeNode26 left = null;
    TreeNode26 right = null;

    public TreeNode26(int val) {
        this.val = val;

    }

}
public class Q26 {
	public List<TreeNode26> list = new ArrayList<TreeNode26>();
	public TreeNode26 Convert(TreeNode26 pRootOfTree) {
		LRDSaveTree(pRootOfTree);
		for(int i=0;i<list.size()-1;i++){
			list.get(i).right = list.get(i+1);
			list.get(list.size()-i-1).left = list.get(list.size()-i-2);
		}
		if(list.size() == 0)
			return pRootOfTree;
		return list.get(0);
    }
	public void LRDSaveTree(TreeNode26 root){
		if(root == null)
			return;
		LRDSaveTree(root.left);
		list.add(root);
		LRDSaveTree(root.right);
	}
}
