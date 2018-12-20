package com.elearning.niuke.interviewquestion58;

/**
 * 面试题58：二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author yangkuan
 */
public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        //情况一：该节点有右子节点
        if(pNode.right!=null){
            return fakeInorderTraversal(pNode.right);
        }
        //情况二：该节点位于祖先节点的左子树中
        else {
            TreeLinkNode indexNode = pNode.next;
            TreeLinkNode childNode = pNode;
            while (indexNode!=null){
                if(indexNode.left==childNode){
                    return indexNode;
                }
                childNode = indexNode;
                indexNode = indexNode.next;
            }
        }
        return null;
    }
    private TreeLinkNode fakeInorderTraversal(TreeLinkNode root){
        if(root.left!=null){
            return fakeInorderTraversal(root.left);
        }
        return root;
    }

    public void test(){
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        a.left = b;
        a.right = c;
        a.next = null;
        b.left = d;
        b.right = e;
        b.next = a;
        c.left = f;
        d.next = b;
        e.next = b;
        f.next = c;
        System.out.print(GetNext(a).val);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
