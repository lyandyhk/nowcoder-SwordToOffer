package problemList;
/**
 * 
 * @author Febiven
 *��Ŀ�����������Ķ�����������任ΪԴ�������ľ���
	��������:
	�������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
public class Q18 {
	public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null || root.right != null){
        	TreeNode temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }
}
/**
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/