package com.elearning.chapter2.interviewquestion6_tree;

public class BinaryTree {
    /**
     * 面试题6：重建二叉树
     * 输入二叉树的前序遍历和中序遍历，重建二叉树
     */
    public BinaryTreeNode constructBinaryTree(int[] preOrders, int[] inOrders){
        if(preOrders.length==0){
            return null;
        }
        //找到根节点值
        int rootValue = preOrders[0];
        //创建根节点
        BinaryTreeNode root = new BinaryTreeNode(rootValue,null,null);

        //在中序遍历序列中找到根节点的位置
        int rootIndexInInOrders = -1;
        for(int i=0;i<inOrders.length;i++){
            if(inOrders[i]==rootValue){
                rootIndexInInOrders = i;
                break;
            }
        }
        //防止输入的遍历数组不一致
        if(rootIndexInInOrders == -1){
            System.out.println("输入的前序和中序遍历数组不一致,遍历中断");
            return null;
        }
        //设置左子树递归
        int leftLength = rootIndexInInOrders;
        int[] leftPreOrders = new int[leftLength];
        System.arraycopy(preOrders,1,leftPreOrders,0,leftLength);
        int[] leftInOrders = new int[leftLength];
        System.arraycopy(inOrders,0,leftInOrders,0,leftLength);
        root.leftChild = constructBinaryTree(leftPreOrders,leftInOrders);

        //设置右子树递归
        int rightLength = inOrders.length-rootIndexInInOrders-1;
        int[] rightPreOrders = new int[rightLength];
        System.arraycopy(preOrders,rootIndexInInOrders+1,rightPreOrders,0,rightLength);
        int[] rightInOrders = new int[rightLength];
        System.arraycopy(inOrders,rootIndexInInOrders+1,rightInOrders,0,rightLength);
        root.rightChild = constructBinaryTree(rightPreOrders,rightInOrders);

        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        //找到根节点
        int rootValue = pre[0];
        //创建根节点
        TreeNode root = new TreeNode(rootValue);
        //在中序遍历序列中找到根节点的位置
        int rootIndexInInOrders = -1;
        for(int i=0;i<in.length;i++){
            if(in[i]==rootValue){
                rootIndexInInOrders = i;
                break;
            }
        }
        //防止输入的遍历数组不一致
        if(rootIndexInInOrders == -1){
            return null;
        }
        //设置左子树递归
        int leftLength = rootIndexInInOrders;
        int[] leftPreOrders = new int[leftLength];
        System.arraycopy(pre,1,leftPreOrders,0,leftLength);
        int[] leftInOrders = new int[leftLength];
        System.arraycopy(in,0,leftInOrders,0,leftLength);
        root.left = reConstructBinaryTree(leftPreOrders,leftInOrders);
        //设置右子树递归
        int rightLength = in.length-rootIndexInInOrders-1;
        int[] rightPreOrders = new int[rightLength];
        System.arraycopy(pre,rootIndexInInOrders+1,rightPreOrders,0,rightLength);
        int[] rightInOrders = new int[rightLength];
        System.arraycopy(in,rootIndexInInOrders+1,rightInOrders,0,rightLength);
        root.right = reConstructBinaryTree(rightPreOrders,rightInOrders);

        return root;
    }
    public void postorderTraversal(BinaryTreeNode root){
        if(root==null){
            return;
        }
        postorderTraversal(root.leftChild);
        postorderTraversal(root.rightChild);
        System.out.print(root.value+" ");
    }
    public void postorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] preOrders = {1,2,3,4,5,6,7};
        int[] inOrders = {3,2,4,1,6,5,7};
        BinaryTreeNode root = binaryTree.constructBinaryTree(preOrders, inOrders);
        binaryTree.postorderTraversal(root);
        System.out.println();
        TreeNode treeNode = binaryTree.reConstructBinaryTree(preOrders,inOrders);
        binaryTree.postorderTraversal(treeNode);
    }
}