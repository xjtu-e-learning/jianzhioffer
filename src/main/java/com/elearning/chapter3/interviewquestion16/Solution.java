package src.main.java.com.elearning.chapter3.interviewquestion16;

/**
 * ，面试题16：反转链表，输入一个链表，反转链表后，输出链表的所有元素。
 * @author yangkuan
 * @date 2018/05/08 15:48
 */
public class Solution {
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return head;
        }
        //定义三个指针
        ListNode last = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current.next!=null){
            current.next = last;

            //指针后移
            last = current;
            current = next;
            next = current.next;
        }
        current.next = last;
        return current;
    }

    public static void printLinkedList(ListNode head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(6,null);
        ListNode node5 = new ListNode(5,tail);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode head = ReverseList(tail);
        printLinkedList(head);
    }

}
