package com.elearning.niuke.interviewquestion61;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题61：把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(pRoot==null){
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                result.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            results.add(result);
        }
        return results;
    }

    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        ArrayList<ArrayList<Integer>> results = Print(a);
        for(ArrayList<Integer> result:results){
            for(Integer r:result){
                System.out.print(r+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }


}
