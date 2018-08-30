package com.elearning.chapter5.interviewquestion37;

/**
 * 面试题37：两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
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

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);

        int lengthDiff = length1 - length2;
        ListNode pHeadLong = pHead1;
        ListNode pHeadShort = pHead2;
        if (lengthDiff < 0) {
            lengthDiff = -lengthDiff;
            pHeadLong = pHead2;
            pHeadShort = pHead1;
        }

        // long list
        for (int i = 0; i < lengthDiff; i++) {
            pHeadLong = pHeadLong.next;
        }
        while (pHeadLong != null && pHeadLong.val != pHeadShort.val) {
            pHeadLong = pHeadLong.next;
            pHeadShort = pHeadShort.next;
        }
        return pHeadLong;
    }

    private int getLength(ListNode pHead) {
        int cnt = 0;
        ListNode tmp = pHead;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        return cnt;
    }

    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        System.out.print(FindFirstCommonNode(node1, node5));
    }


    public static void main(String[] args) {
        new Solution().test();
        //System.out.print("hello");
    }
}
