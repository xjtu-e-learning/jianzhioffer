package com.elearning.niuke.interviewquestion60;


import java.util.*;

/**
 * 面试题60：按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if(pRoot==null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean leftToRight = false;

        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            int size = queue.size();
            leftToRight ^= true;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //从左到右加入
                if(leftToRight){
                    result.add(node.val);
                }
                //利用栈，从右到左加入
                else {
                    stack.push(node);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            while (!stack.empty()){
                result.add(stack.pop().val);
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
