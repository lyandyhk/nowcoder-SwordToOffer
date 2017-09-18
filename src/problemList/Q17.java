package problemList;

/**
 * 
 * @author Febiven
 *	题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *	
 *	分析：
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    
}
public class Q17 {
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
        if(root1 == null || root2 == null)
        	return false;
        if(root1.val == root2.val)
        	result = isEquals(root1,root2);
        if(!result)
        	return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
        else
        	return true;
    }
	public static boolean isEquals(TreeNode root1,TreeNode root2){
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.val == root2.val)
			return isEquals(root1.left, root2.left)&&isEquals(root1.right, root2.right);
		else
			return false;
	}
}
