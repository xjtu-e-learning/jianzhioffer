package com.elearning.chapter6.interviewquestion39;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        Map<String, Object> result = isBalanced(root);
        return (Boolean) result.get("isBalanced");
    }

    private Map<String,Object> isBalanced(TreeNode node){
        Map<String, Object> result = new HashMap<>(2);
        if(node==null){
            result.put("depth",0);
            result.put("isBalanced",true);
            return result;
        }
        Map<String, Object> left_result = isBalanced(node.left);
        Map<String, Object> right_result = isBalanced(node.right);
        Integer left = (Integer) left_result.get("depth");
        Integer right = (Integer) right_result.get("depth");

        Boolean left_isBalanced = (Boolean) left_result.get("isBalanced");
        Boolean right_isBalanced = (Boolean) right_result.get("isBalanced");
        if(left_isBalanced&&right_isBalanced){
            int depth = (left>right)?left+1:right+1;
            int diff = left-right;
            if(diff<=1&&diff>=-1){
                result.put("depth",depth);
                result.put("isBalanced",true);
                return result;
            }
        }
        result.put("depth",0);
        result.put("isBalanced",false);
        return result;
    }


    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node2.right = node3;
        /*System.out.println(TreeDepth(node1));
        System.out.println(TreeDepth(node2));
        System.out.print(TreeDepth(node3));*/
        System.out.print(IsBalanced_Solution(node1));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
