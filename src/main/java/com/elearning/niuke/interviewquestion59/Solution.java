package com.elearning.niuke.interviewquestion59;

/**
 * 面试题59：对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        return isSymmetricalChildren(pRoot.left,pRoot.right);
    }

    boolean isSymmetricalChildren(TreeNode leftChild,TreeNode rightChild){
        if(leftChild==null&&rightChild==null){
            return true;
        }
        if(leftChild==null||rightChild==null){
            return false;
        }
        if(leftChild.val!=rightChild.val){
            return false;
        }
        return isSymmetricalChildren(leftChild.left,rightChild.right)
                &&isSymmetricalChildren(leftChild.right,rightChild.left);
    }
}
