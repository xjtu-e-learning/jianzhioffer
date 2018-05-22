package src.main.java.com.elearning.chapter3.interviewquestion17;
/**
 * 链表节点
 * @author yangkuan
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    ListNode(int val) {
        this.val = val;
    }
}
