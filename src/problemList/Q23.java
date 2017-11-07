package problemList;


import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author Febiven
 *
 *思路：
 *	1.写一个递归方法IsTree来判断给的后续遍历数组是不是一棵树
 *	2.长度为0说明该递归到此没有出现问题，已经结束了，长度为1说明只有这一个节点了，返回true（但如果给的数组是空数组，按题目意思返回false，这个无关紧要）
 *	3.因为是后序遍历，所以父节点在最后，所以，先拿到父节点，然后从前往后找到第一个大于父节点的数，该节点索引记作RIndex，从RIndex到父节点之间的这些节点
 *	    由于后序遍历的关系，都不可能小于父节点，所以只要出现比父节点小的数，直接返回false
 *	4.如果都没有问题，那么把除父节点外的数组中的其他数以RIndex为界限（RIndex划分到右侧）分为两部分，其实也就是父节点的左子树与右子树，递归调用IsTree
 *	     如果都没有问题，返回true，中间任何一步出现问题，返回false
 */

public class Q23 {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0)
			return false;
        return isTree(sequence);
    }
	public static boolean isTree(int [] array){
		if(array.length == 0 || array.length == 1)
			return true;
		int degree = array[array.length-1];
		int RIndex = array.length-1;
		for(int i=0;i<array.length-1;i++){
			if(array[i]>degree){
				RIndex = i;
				break;
			}
		}
		for(int i=RIndex;i<array.length-1;i++){
			if(array[i]<degree)
				return false;
		}
		int[] LArray = Arrays.copyOfRange(array, 0, RIndex);
		int[] RArray = Arrays.copyOfRange(array, RIndex, array.length-1);
		if(isTree(LArray) && isTree(RArray))
			return true;
		return false;
	}
	public static void main(String[] args) {
		Q23 q = new Q23();
		System.out.println(q.VerifySquenceOfBST(new int[]{1,4,3,7,5,9,12,10,8}));
	}
}
