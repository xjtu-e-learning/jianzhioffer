package src.main.java.com.elearning.chapter4.interviewquestion19;

import sun.reflect.generics.tree.Tree;

import java.util.FormatFlagsConversionMismatchException;

/**
 * 面试题19：二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {

    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        //交换左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void printTree(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(10);
        TreeNode root = new TreeNode(8);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        solution.Mirror(root);
        printTree(root);
    }
}
