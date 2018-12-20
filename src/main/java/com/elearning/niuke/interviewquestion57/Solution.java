package com.elearning.niuke.interviewquestion57;

import java.util.HashMap;

/**
 * 面试题57：删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        HashMap<Integer,Integer> isExisted = new HashMap<>();
        ListNode index = pHead;
        while (index!=null){
            if(isExisted.containsKey(index.val)){
                isExisted.put(index.val,isExisted.get(index.val)+1);
            }
            else {
                isExisted.put(index.val,1);
            }
            index = index.next;
        }
        ListNode lastIndex = pHead;
        ListNode currentIndex = pHead.next;
        while (currentIndex!=null){
            if(isExisted.get(currentIndex.val)>1){
                lastIndex.next = currentIndex.next;
                currentIndex = currentIndex.next;
            }
            else {
                lastIndex = lastIndex.next;
                currentIndex = currentIndex.next;
            }
        }
        if(isExisted.get(pHead.val)>1){
            return pHead.next;
        }
        return pHead;
    }

    /**
     * 方法2：递归
     * @param pHead
     * @return
     */
    public ListNode deleteDuplicationSecondMethod(ListNode pHead) {
        // 只有0个或1个结点，则返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 当前结点是重复结点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
            // 当前结点不是重复结点
        } else {
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


    public void test(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        deleteDuplication(a);
        while (a!=null){
            System.out.print(a.val+" ");
            a = a.next;
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
