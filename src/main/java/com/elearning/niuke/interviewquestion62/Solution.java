package com.elearning.niuke.interviewquestion62;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62：序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
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

    int index = 0;

    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val+",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return Deserialize(strings);
    }
    TreeNode Deserialize(String[] strings){
        if(strings[index].equals("#")){
            index++;
            return null;
        }
        Integer val = Integer.valueOf(strings[index]);
        TreeNode treeNode  = new TreeNode(val);
        index++;
        treeNode.left = Deserialize(strings);
        treeNode.right = Deserialize(strings);
        return treeNode;
    }
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        String s = Serialize(a);
        System.out.println(s);
        TreeNode root = Deserialize(s);
    }

    public static void main(String[] args) {
        //new Solution().test();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.subList(0,2));
    }
}
