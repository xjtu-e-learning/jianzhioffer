package com.elearning.chapter4.interviewquestion26;

/**
 * 面试题26：复杂链表的复制
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点
 * ，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author yangkuan
 */
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        //第一步复制next链表
        cloneNodes(pHead);
        //第二步复制随机链表
        cloneRandomNodes(pHead);
        //拆分
        return reconnetNodes(pHead);
    }

    /**
     * 第一步复制next链表
     */
    private void cloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode clonedNode = new RandomListNode(node.label);
            clonedNode.next = node.next;
            clonedNode.random = null;

            node.next = clonedNode;
            node = clonedNode.next;
        }
    }

    /**
     * 第二步复制随机链表
     */
    private void cloneRandomNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode pClonedNode = node.next;
            if(node.random!=null){
                pClonedNode.random = node.random.next;
            }
            node = pClonedNode.next;
        }
    }
    /**
     * 拆分
     */
    private RandomListNode reconnetNodes(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if(node!=null){
            pClonedHead = node.next;
            pClonedNode = node.next;
            node.next = pClonedHead.next;
            node = node.next;
        }
        while (node!=null){
            pClonedNode.next = node.next;
            pClonedNode = pClonedNode.next;
            node.next = pClonedNode.next;
            node = node.next;
        }
        return pClonedHead;
    }

    public static void main(String[] args) {

    }
}
