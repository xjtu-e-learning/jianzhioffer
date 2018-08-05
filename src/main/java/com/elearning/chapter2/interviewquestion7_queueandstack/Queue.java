package com.elearning.chapter2.interviewquestion7_queueandstack;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * 实现队尾添加和队头删除操作
 */
public class Queue {
    private Stack stack_input;
    private Stack stack_output;

    public Queue() {
    }

    public Queue(Stack stack_input, Stack stack_output) {
        this.stack_input = stack_input;
        this.stack_output = stack_output;
    }
    public Object deleteHead(){
        //判断stack_output是否为空，如果非空，出栈
        Object head;
        if(!stack_output.empty()){
            head = stack_output.pop();
        }
        //否则stack_input非空，将stack_input中的所有元素出栈，压入stack_output
        else if(!stack_input.empty()){
            while (!stack_input.empty()){
                stack_output.push(stack_input.pop());
            }
            head = stack_output.pop();
        }
        //如果两个栈都为空，那么报错，返回null
        else {
            head = null;
            System.out.println("队列为空，删除队列头失败");
        }
        return head;
    }

    public void appendTail(Object tail){
        //向stack_input中添加，也就是压栈
        stack_input.push(tail);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(new Stack(), new Stack());
        queue.appendTail("1");
        queue.appendTail("2");
        queue.appendTail("3");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
