package src.main.java.com.elearning.chapter4.interviewquestion21;

import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author yangkuan
 * @date 2018/05/22
 */
public class Solution {
    /**
     * 数据栈
     */
    Stack<Integer>  dataStack = new Stack<>();
    /**
     * 最小数据栈
     */
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.size()==0||minStack.peek()>node){
            minStack.push(node);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
