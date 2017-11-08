package problemList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author Febiven
 * 思路：  递归  :交换其中两个的基础上继续交换下去
 * 		不重复:set
 * 		排好序:Collections.sort(List list);
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
