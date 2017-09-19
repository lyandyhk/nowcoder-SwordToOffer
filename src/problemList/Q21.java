package problemList;

import java.util.ArrayList;

/**
 * 
 * @author Febiven
 *	题目：
 *	输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *	假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5，3，2，1是该压栈序列对应的一个弹出序列，
 *	但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 *
 *	思路：
 *	解决这题，要明白两个要点
 *		1.我们对每一个元素需要知道的是它的序号，而不是它的值是几
 *		     例如：入栈顺序 2 3 1 5 4 ，我们要的信息的2是1号入栈，3是2号入栈，以此类推，因为我们要操作的是值得序号是否合理，而不是这个值是否合理
 *		2.出栈顺序是否合理，可以这么说，比如我们拿入栈顺序为1 2 3 4 5 来说，如果大序号的元素先出栈，那么比他小的元素必定按序号从大到小依次出栈
 *		    如果中途出现了大序号的先出（比如4号），此时又出了一个较小序号的，比如（2），如果之后再出了一个比2大，比4小的数，那么肯定是不合理的。
 *		    因为先出大的序号，小的序号肯定是按规律入栈的，不可能先出一个小的序号再出一个大的序号。
 *		 （如果按 1 2 3 4 5来说的话，先出4之后直接出2，这时我们直接就知道不合理了，但我们现在讨论一般规律）
 *		3.还有一点小小的需要注意的地方就是，如果入栈数组和出栈数组给的值有不一样直接返回false
 *
 *
 *
 */

public class Q21 {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		int max = -1,min = -1;
		if(pushA.length == 0){
			return false;
		}
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i=0;i<pushA.length;i++)
	    	list.add(pushA[i]);
	    for(int i=0;i<popA.length;i++){
	    	int offset = list.indexOf(popA[i]);
	    	if(offset == -1)
	    		return false;
	    	if(offset>max){
	    		max = offset;
	    		continue;
	    	}
	    	if(min == -1){
	    		min = offset;
	    		continue;
	    	}
	    		
	    	if(offset<min){
	    		min = offset;
	    		continue;
	    	}
	    	if((max != -1 && min != -1))
	    		return false;
	    }
	    return true; 
	}
}
