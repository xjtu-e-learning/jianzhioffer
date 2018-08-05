package com.elearning.chapter2.interviewquestion5_linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class LinkListImpl {
    /**
     * 逆序打印链表
     * @param head
     */
    private static void printListReveringly(ListNode head){
        //遍历链表，把元素放入栈中
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode index = head;
        while (index != null){
            stack.push(index);
            index = index.getNext();
        }
        while (!stack.empty()){
            System.out.println(stack.pop().getValue());
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //遍历链表，把元素放入栈中
        Stack<ListNode> stack = new Stack<ListNode>();
        while (listNode !=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!stack.empty()){
            result.add(stack.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        printListReveringly(node1);
    }

}
