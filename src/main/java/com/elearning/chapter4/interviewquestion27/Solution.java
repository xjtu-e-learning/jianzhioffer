package com.elearning.chapter4.interviewquestion27;

/**
 * 面试题27：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author yangkuan
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = null;
        if(pRootOfTree==null){
            return null;
        }
        pLastNodeInList = convertNode(pRootOfTree,pLastNodeInList);

        //get the head of list
        TreeNode head = pLastNodeInList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private TreeNode convertNode(TreeNode pRootOfTree,TreeNode pLastNodeInList) {
        if (pRootOfTree.left != null) {
            pLastNodeInList = convertNode(pRootOfTree.left,pLastNodeInList);
        }
        pRootOfTree.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pRootOfTree;
        }
        pLastNodeInList = pRootOfTree;
        if (pRootOfTree.right != null) {
            pLastNodeInList = convertNode(pRootOfTree.right,pLastNodeInList);
        }
        return pLastNodeInList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(12);
        TreeNode treeNode5 = new TreeNode(14);
        TreeNode treeNode6 = new TreeNode(16);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode5;
        treeNode1.left = treeNode;
        treeNode1.right = treeNode2;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;
        TreeNode head = new Solution().Convert(treeNode3);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.right;
        }
        System.out.println();
    }
}
