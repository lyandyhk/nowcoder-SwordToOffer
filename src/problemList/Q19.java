package problemList;

import java.util.ArrayList;

/**
 * 
 * @author Febiven
 *	��Ŀ������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬
 *	����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	�����δ�ӡ������    1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	
	
	����˼·��
			 1   2   3   4
			 5   6   7   8
			 9   10  11  12
			 13  14  15  16
			 
		1.�������������ǿ����飬����һά���Ƕ�ά�ϣ�ֱ�ӷ����µ�ArrayList����
		2.���õ������һά�������ά���ȣ�һά������Ϊx����ά������Ϊy
		3.������һ����ǰλ�õ�xy���꣬ȡ��Ϊcx��cy
		4.���˳ʱ����ת�Ļ������ǿ������Ϊ����һ����Ȧ�������Ȧ�󷵻ص�����ǰһ��λ�ã�����ͼ�е�5��Ȼ�����������Сһ���Ȧ
		5.x y���ǿ������Ϊ��ǰȦ�ĳ������Դ������Ҹ���4��ѭ����Ҳ���������Ȧ���ĸ��ߵĶ�Ӧ�����������˵�ǰȦ֮����ͼ���ߵ�5֮��
		    �����õ�ǰ�����꣨cx����һ������СȦ������ѭ������ʱСȦ�ĳ�����ԭ����Ȧ�ĳ���-2��ֱ��xy��ĳһ����Ϊ0����ѭ������
		6.������һЩ�������������ĳһ���߳���Ϊ1��Ҳ����һ���ߵ�ʱ����ʱ����������������ƣ�
		     ��ô���ǰ����ѭ��һ�飬Ȼ��Ӻ�ǰ��ѭ��һ�飬���磺
		     		1 2 3 4 5 6 7
		     ����������жϣ���ô������� 1 2 3 4 5 6 7 6 5 4 3 2 ���ֽ��
		     ���ԣ�������ĳ���߳���Ϊһʱ��ֻ��Ҫ�����������һ�鼴�ɣ�����Ҫ�ڶ��顣
		7.�Դˣ����̽���
				
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
