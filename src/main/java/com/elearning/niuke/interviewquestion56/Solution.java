package com.elearning.niuke.interviewquestion56;

/**
 * 面试题56：链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author yangkuan
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null||pHead.next.next== null){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        //先寻找交汇点，速度不同
        while (slow!=fast){
            if(slow.next==null||fast.next.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //再次寻找交汇点，速度相同
        ListNode index = pHead;
        while (index!=slow){
            index = index.next;
            slow = slow.next;
        }
        return index;
    }
}
