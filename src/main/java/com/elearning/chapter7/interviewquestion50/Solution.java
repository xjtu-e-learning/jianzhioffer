package com.elearning.chapter7.interviewquestion50;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题50：树中两个节点的最低公共祖先
 * @author yangkuan
 */
public class Solution {
    /**
     * 寻找节点路径
     * @param root
     * @param node
     * @param path
     */
    public boolean getNodePath(TreeNode root, TreeNode node, List<TreeNode> path){
        //先序遍历
        path.add(root);
        if(root==node){
            return true;
        }
        if(root==null){
            path.remove(path.size()-1);
            return false;
        }
        boolean flag = true;
        for(TreeNode child:root.children){
            boolean currentFlag = getNodePath(child,node,path);
            flag = flag && currentFlag==false;
        }
        if(flag){
            path.remove(path.size()-1);
            return false;
        }
        else {
            return true;
        }
    }

    public TreeNode getLastCommonNode(List<TreeNode> path1,List<TreeNode> path2){
        int i = 0;
        while (path1.get(i)==path2.get(i)){
            i++;
        }
        return path1.get(i-1);
    }

    public TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2){
        if(root==null||node1==null||node2==null){
            return null;
        }
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        getNodePath(root,node1,path1);
        getNodePath(root,node2,path2);

        return getLastCommonNode(path1,path2);
    }

    public void buildTree(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);
        a.children.add(b);
        a.children.add(c);
        b.children.add(d);
        b.children.add(e);
        d.children.add(f);
        d.children.add(g);
        e.children.add(h);
        e.children.add(i);
        e.children.add(j);

        TreeNode commonParent = getLastCommonParent(a,c,f);
        System.out.println(commonParent.val);
    }

    public static void main(String[] args) {
        new Solution().buildTree();
    }

}
