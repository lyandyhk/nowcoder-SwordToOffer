package problemList;



import java.util.Stack;

/**
 * 
 * @author Febiven
 *	��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 *	
 *	˼·����Ŀֱ�Ӹ���java.util.Stack����ֱ�������þͺ��ˣ�ԭʼ����ûʲô˵�ģ���Ҫ�����min()����
 *	ע��㣺���ﲻ��ֻ��int���ͱ�����һ��minֵ����Ϊ�����min��pop��ȥ֮����ô��һ��min��ʲô��
 *	����һ���������б�������Сֵ������ÿ�ζ�Ҫ��һ���������н��и��Ӷ�ΪO��n��*m���������ԣ���취���ã���������취
 *	����������������ĳ�˴��룬��һ������С����ջ�������
 *		���ջ�Ķ����ǣ��������ԭʼջ�����ȵ�ǰ��Сջ�Ķ�Ԫ��С���ߵ��ڵ�ǰ��Сջ��Ԫ�أ���ôͬʱ�����Ҳѹ����Сջ
 *		��ԭʼջpopʱ�������Ԫ�ص�����Сջ��Ԫ�أ���ô��Сջ��Ԫ��Ҳ��ջ��
 *	
 *	ps��peek()�������ǻ�ȡ��ǰջ��Ԫ�أ��������������ջ��
 *		
 */

public class Q20 {
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Stack<Integer> minstack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(minstack.isEmpty())
        	minstack.push(node);
        else{
        	if(node<= minstack.peek())
        		minstack.push(node);
        }
        	
        	
    }
    
    public void pop() {
    	int i = stack.pop();
    	if(i == minstack.peek())
    		minstack.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int min() {
        return minstack.peek();
    }
    public static void main(String[] args) {
		Q20 q = new Q20();
		q.push(3);
		System.out.println(q.min());
		q.push(4);
		System.out.println(q.min());
		q.push(2);
		System.out.println(q.min());
		q.push(3);
		System.out.println(q.min());
		q.pop();
		System.out.println(q.min());
		q.pop();
		System.out.println(q.min());
		q.pop();
		System.out.println(q.min());
		q.push(0);
		System.out.println(q.min());
	}
}
