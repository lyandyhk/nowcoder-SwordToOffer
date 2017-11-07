package problemList;


import java.util.ArrayList;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * @author Febiven
 *
 *
 * ˼·������ûɶ˵�ģ����⣬��Ҫע���һ������Ŀû˵����Ƿ��п���Ϊ���������Ϊ�������Ǿͱ����󵽵��ˣ�����Ļ���ֻ��Ҫ�ж�����
 * 	1.������ǰ�ڵ�ʱ������ܺ͵���target
 * 		1.���������������ôֱ��pass������Ϊ�����κ�һ��·���϶������target
 * 		2.���û����������ô������·���ӵ�������棬��·������
 * 	2.������ǰ�ڵ�ʱ������ܺʹ���target��Ҳֱ��pass��
 * 	3.������ǰ�ڵ�ʱ������ܺ�С��target
 * 		1.�������������������򶼴��ڣ��Ǿ͵ݹ����searchAndSavePath
 * 		2.���������Ǵ�·����pass��
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
		 // ������Ŀû˵�������������Ҫ����һ��������ڵ�������и�����ô�죬sum�����ϻ������ؼ�����ʱ���һ��Ҫ��Ҷ�ӽ��Ϊֹ
		 // ���Է�����������ۣ���һ���ǲ����ڸ������������������²�һ��Ҫ��Ҷ�ӽ��Ϊֹ��ֻҪ����target�˱�Ȼ����������ʡ��ʱ��
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
		 //������������Ǵ��ڸ���������£��Ǿͱ����󵽵���
		 
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
