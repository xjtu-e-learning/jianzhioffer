package com.elearning.chapter6.interviewquestion39;

/**
 * 面试题39：二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
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
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        System.out.println(TreeDepth(node1));
        System.out.println(TreeDepth(node2));
        System.out.print(TreeDepth(node3));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
