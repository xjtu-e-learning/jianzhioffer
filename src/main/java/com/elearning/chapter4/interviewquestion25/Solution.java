package com.elearning.chapter4.interviewquestion25;

import java.util.ArrayList;

/**
 * 面试题25：二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversal(root, target, result, results);
        return results;
    }


    public void preorderTraversal(TreeNode root, int target, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
        result.add(root.val);
        //树节点，且和为目标值
        if (getSum(result) == target && root.left == null && root.right == null) {
            ArrayList<Integer> newResult = new ArrayList<>();
            newResult.addAll(result);
            results.add(newResult);
        }
        if (root.left != null) {
            preorderTraversal(root.left, target, result, results);
        }
        if (root.right != null) {
            preorderTraversal(root.right, target, result, results);
        }
        result.remove(result.size() - 1);
    }

    private int getSum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private void printResult(ArrayList<Integer> result) {
        for (Integer number : result) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(12);
        TreeNode root = new TreeNode(10);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        ArrayList<ArrayList<Integer>> results = new Solution().FindPath(root, 22);
        for (ArrayList<Integer> result : results) {
            for (Integer number : result) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}
