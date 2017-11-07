package problemList;


import java.util.Arrays;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 * @author Febiven
 *
 *˼·��
 *	1.дһ���ݹ鷽��IsTree���жϸ��ĺ������������ǲ���һ����
 *	2.����Ϊ0˵���õݹ鵽��û�г������⣬�Ѿ������ˣ�����Ϊ1˵��ֻ����һ���ڵ��ˣ�����true����������������ǿ����飬����Ŀ��˼����false������޹ؽ�Ҫ��
 *	3.��Ϊ�Ǻ�����������Ը��ڵ���������ԣ����õ����ڵ㣬Ȼ���ǰ�����ҵ���һ�����ڸ��ڵ�������ýڵ���������RIndex����RIndex�����ڵ�֮�����Щ�ڵ�
 *	    ���ں�������Ĺ�ϵ����������С�ڸ��ڵ㣬����ֻҪ���ֱȸ��ڵ�С������ֱ�ӷ���false
 *	4.�����û�����⣬��ô�ѳ����ڵ���������е���������RIndexΪ���ޣ�RIndex���ֵ��Ҳࣩ��Ϊ�����֣���ʵҲ���Ǹ��ڵ�������������������ݹ����IsTree
 *	     �����û�����⣬����true���м��κ�һ���������⣬����false
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
