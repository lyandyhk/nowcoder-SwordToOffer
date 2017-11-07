package problemList;


import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author Febiven
 *
 *
 * 思路：这题没啥说的，简单题，需要注意的一点是题目没说结点是否有可能为负数，如果为负数，那就必须求到底了，否则的话，只需要判断三点
 * 	1.当到当前节点时，如果总和等于target
 * 		1.如果还有子树，那么直接pass掉，因为以下任何一条路径肯定会大于target
 * 		2.如果没有子树，那么把这条路径加到结果里面，此路径结束
 * 	2.当到当前节点时，如果总和大于target，也直接pass掉
 * 	3.当到当前节点时，如果总和小于target
 * 		1.存在左子树或右子树或都存在，那就递归调用searchAndSavePath
 * 		2.都不存在那此路径就pass掉
 */

class TreeNode3 {
    int val = 0;
    TreeNode3 left = null;
    TreeNode3 right = null;

    public TreeNode3(int val) {
        this.val = val;

    }

}
public class Q24 {
	 public int target;
	 public ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode3 root,int target) {
		 this.target = target;
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 int sum = 0;
		 searchAndSavePath(root, list, sum);
		 return lists;
	 }
	 public void searchAndSavePath(TreeNode3 node,ArrayList<Integer> list,int sum){
		 if(node == null && target == 0)
			 return;
		 sum = sum + node.val;
		 list.add(node.val);
		 // 由于题目没说清楚，所以我们要考虑一种情况，节点中如果有负数怎么办，sum基础上还会往回减，这时候就一定要求到叶子结点为止
		 // 所以分两种情况讨论，第一种是不存在负数的情况，这种情况下不一定要求到叶子结点为止，只要大于target了必然不成立，节省了时间
		 if(sum <= target){
			 if(sum == target && node.left == null && node.right == null){
				 lists.add(list);
				 return;
			 }
			 else if(sum < target){
				 if(node.left != null){
					 searchAndSavePath(node.left, new ArrayList<Integer>(list), sum);
				 }
				 if(node.right != null){
					 searchAndSavePath(node.right, new ArrayList<Integer>(list), sum);
				 }
			 }
		 }
		 //下面这种情况是存在负数的情况下，那就必须求到底了
		 
//		 if(sum == target && node.left == null && node.right == null){
//			 lists.add(list);
//			 return;
//		 }
//		 if(node.left != null){
//			 searchAndSavePath(node.left, new ArrayList<Integer>(list), sum);
//		 }
//		 if(node.right != null){
//			 searchAndSavePath(node.right, new ArrayList<Integer>(list), sum);
//		 }
	 }
}
