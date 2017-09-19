package problemList;



import java.util.Stack;

/**
 * 
 * @author Febiven
 *	题目：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *	
 *	思路：题目直接给了java.util.Stack，那直接拿来用就好了，原始操作没什么说的，主要是这个min()方法
 *	注意点：这里不能只用int类型变量存一个min值，因为当这个min被pop出去之后，那么下一个min是什么。
 *	方法一：用有序列表来存最小值，但是每次都要存一个数，还有进行复杂度为O（n）*m的排序，所以，这办法能用，但是算蠢办法
 *	方法二：后来看到某人代码，用一个存最小数的栈来解决。
 *		这个栈的定义是，如果存入原始栈的数比当前最小栈的顶元素小或者等于当前最小栈顶元素，那么同时这个数也压入最小栈
 *		当原始栈pop时，如果该元素等于最小栈顶元素，那么最小栈顶元素也出栈。
 *	
 *	ps：peek()的意义是获取当前栈顶元素，但是这个数不出栈。
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
