package com.elearning.chapter4.interviewquestion23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(10);
        TreeNode root = new TreeNode(8);
        root.left = left;
        root.right = right;
        ArrayList<Integer> list = new Solution().PrintFromTopToBottom(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
