package problemList;

import java.util.ArrayList;

/**
 * 
 * @author Febiven
 *	题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 *	如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	则依次打印出数字    1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	
	
	解题思路：
			 1   2   3   4
			 5   6   7   8
			 9   10  11  12
			 13  14  15  16
			 
		1.如果传入的数组是空数组，无论一维或是二维上，直接返回新的ArrayList对象
		2.先拿到数组的一维长度与二维长度，一维长度设为x，二维长度设为y
		3.再设置一个当前位置的xy坐标，取名为cx，cy
		4.如果顺时针旋转的话，我们可以理解为先走一个大圈，走完大圈后返回到起点的前一个位置，例如图中的5，然后再走里面的小一层的圈
		5.x y我们可以理解为当前圈的长宽，所以代码中我给了4段循环，也就是走这个圈的四个边的对应操作，走完了当前圈之后（如图中走到5之后）
		    我们让当前横坐标（cx）加一，进入小圈，继续循环，此时小圈的长宽都是原来大圈的长度-2，直到xy中某一条边为0，则循环结束
		6.其中有一些特殊情况，比如某一条边长度为1，也就是一条线的时候，这时候如果不加条件限制，
		     那么会从前到后循环一遍，然后从后到前再循环一遍，例如：
		     		1 2 3 4 5 6 7
		     如果不加以判断，那么将会出现 1 2 3 4 5 6 7 6 5 4 3 2 这种结果
		     所以，当出现某条边长度为一时，只需要横或者竖遍历一遍即可，不需要第二遍。
		7.自此，流程结束
				
 */
public class Q19 {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        int y = matrix.length;
        if(y<=0)
        	return new ArrayList<Integer>();
        int x = matrix[0].length;
        if(x<=0)
        	return new ArrayList<Integer>();
        int cx = 0,cy = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(x>0&&y>0){
        	result.add(matrix[cy][cx]);
        	for(int i=0;i<x-1;i++){
        		result.add(matrix[cy][++cx]);
        	}
        	for(int i=0;i<y-1;i++){
        		result.add(matrix[++cy][cx]);
        	}
        	if(x != 1&&y != 1){
        		for(int i=0;i<x-1;i++){
        			result.add(matrix[cy][--cx]);
            	}
        	}
        	if(x != 1&&y != 1){
        		for(int i=0;i<y-2;i++){
        			result.add(matrix[--cy][cx]);
            	}
        	}
        	cx++;
        	x = x-2;
        	y = y-2;
        }
        return result;
    }
	public static void main(String[] args) {
		Q19 q = new Q19();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[][] data = new int[5][2];
		int count = 1;
		for(int i=0;i<5;i++){
			for(int j=0;j<2;j++){
				data[i][j] = count++;
			}
		}
		result = q.printMatrix(data);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
}
