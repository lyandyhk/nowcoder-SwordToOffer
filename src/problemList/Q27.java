package problemList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @author Febiven
 * ˼·��  �ݹ�  :�������������Ļ����ϼ���������ȥ
 * 		���ظ�:set
 * 		�ź���:Collections.sort(List list);
 */ 
public class Q27 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if(str == null || str.length() == 0)
			return list;
	    char[] arr = str.toCharArray();
	    Set<String> set = new HashSet<String>();
	    findAndInsert(set, 0, arr);
	    list.addAll(set);
	    Collections.sort(list);
	    return list;
    }
	public void findAndInsert(Set<String> set,int k,char[] arr){
		int length = arr.length;
		if(k == length)
			set.add(String.valueOf(arr));
		for(int i=k;i<length;i++){
			swap(arr,i,k);
			findAndInsert(set, k+1, arr);
			swap(arr,i,k);
		}
	}
	public void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
