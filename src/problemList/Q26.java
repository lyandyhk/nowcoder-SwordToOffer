package problemList;

import java.util.ArrayList;
import java.util.List;


/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author Febiven
 *
 *	
 *	���룺�������������ڵ�
 *	��������нڵ��ź��򣬲����Ǵ������ң����������˫�������������������ñ�����ҽڵ������
 *	ע�⣺���ܴ����µĽڵ�
 *	˼·��ͨ����������ѽڵ����һ�������б��У��ٴ����ң����ҵ����������������ص�һ��root�ڵ㼴��
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
