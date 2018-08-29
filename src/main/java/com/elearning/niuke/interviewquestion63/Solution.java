package com.elearning.niuke.interviewquestion63;

import java.util.Stack;

/**
 * 面试题63：二叉搜索树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * @author yangkuan
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
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<0){
            return null;
        }
        TreeNode result = null;
        //非递归中序遍历
        int cnt = 1;
        TreeNode node = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            TreeNode peakNode = stack.pop();
            if(cnt==k){
                result = peakNode;
                break;
            }
            cnt++;
            node = peakNode.right;
        }
        return result;
    }

}
