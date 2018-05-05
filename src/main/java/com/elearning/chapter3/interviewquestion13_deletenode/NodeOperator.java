package src.main.java.com.elearning.chapter3.interviewquestion13_deletenode;

/**
 * 面试题13：在O（1）时间删除链表节点
 * @author yangkuan
 * @date 2018/05/03 22:18
 */
public class NodeOperator {

    /**
     * 删除链表中的节点
     * @param head
     * @param nodeToBeDeleted
     * @return 返回头结点
     */
    public ListNode deleteNode(ListNode head,ListNode nodeToBeDeleted){
        //三种情况
        //首先，如果链表只有一个元素，那么直接删除，并且把头结点置为NULL
        if(head==null&&nodeToBeDeleted==null){
            return null;
        }
        if(head.next==null&&nodeToBeDeleted.next==null){
            head = null;
        }
        //其次，如果待删除节点是尾节点，那么只能遍历
        else if(nodeToBeDeleted.next==null){
            ListNode index = head;
            while (index.next!=null){
                if(index.next==nodeToBeDeleted){
                    index.next = null;
                    break;
                }
                index = index.next;
            }
        }
        //最后，如果待删除节点是中间节点，正常删除
        else {
            //复制下一个节点
            ListNode tmp = nodeToBeDeleted.next;
            nodeToBeDeleted.next = tmp.next;
            nodeToBeDeleted.value = tmp.value;
        }
        return head;
    }
    public void printLinkedList(ListNode head){

        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        NodeOperator nodeOperator = new NodeOperator();
        ListNode tail = new ListNode(2,null);
        ListNode mid = new ListNode(3,tail);
        ListNode head = new ListNode(4,mid);

        System.out.println("删除非尾节点");
        head = nodeOperator.deleteNode(head, head);
        nodeOperator.printLinkedList(head);
        System.out.println("删除尾节点");
        head = nodeOperator.deleteNode(head, tail);
        nodeOperator.printLinkedList(head);
        System.out.println("只有一个元素的链表");
        ListNode oneNode = new ListNode(10,null);
        oneNode = nodeOperator.deleteNode(oneNode,oneNode);
        nodeOperator.printLinkedList(oneNode);


    }
}
