package src.main.java.com.elearning.chapter3.interviewquestion15;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * 面试题15：链表的倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author yangkuan
 */
public class LinkedListOperator {

    /**
     * 倒数第k个，定义两个指针距离k-1
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null||k == 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode behind = head;
        //ahead 先往前走k-1步
        for(int i=0;i<(k-1);i++){
            if(ahead.next!=null){
                ahead = ahead.next;
            }
            //如果往前走不动了，那么说明链表不够长
            else {
                return null;
            }
        }
        //判断尾巴
        while (ahead.next!=null){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(6,null);
        ListNode node5 = new ListNode(5,tail);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(FindKthToTail(node1,7).value);

    }
}
