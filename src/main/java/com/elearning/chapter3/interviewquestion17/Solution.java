package src.main.java.com.elearning.chapter3.interviewquestion17;

/**
 * 面试题17：合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author yangkuan
 * @date 2018/05/11 21:53
 */
public class Solution {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        ListNode head;
        ListNode index;
        if(list1.val<list2.val){
            index = list1;
            list1 = list1.next;
        }
        else {
            index = list2;
            list2 = list2.next;
        }
        head = index;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                index.next = list1;
                index = index.next;
                list1 = list1.next;
            }
            else {
                index.next = list2;
                index = index.next;
                list2 = list2.next;
            }
        }
        if(list1!=null){
            index.next = list1;
        }
        if(list2!=null){
            index.next = list2;
        }
        return head;
    }
    public static ListNode MergeRecursion(ListNode list1,ListNode list2) {
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        ListNode head;
        if(list1.val<list2.val){
            head = list1;
            head.next = MergeRecursion(list1.next,list2);
        }
        else {
            head = list2;
            head.next = MergeRecursion(list1,list2.next);
        }
        return head;
    }
    public static void printLinkedList(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(6,null);
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,tail);
        ListNode node3 = new ListNode(3,node5);
        ListNode node2 = new ListNode(2,node4);
        ListNode node1 = new ListNode(1,node3);
//        printLinkedList(Merge(null,null));
        printLinkedList(MergeRecursion(node1,tail));
    }

}
