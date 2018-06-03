package com.elearning.chapter4.interviewquestion24;

import java.util.Arrays;

/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author yangkuan
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        //寻找分割点
        int i;
        for (i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //搜索右子树中是否有小于根的点
        int j = i;
        for (;j<sequence.length-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        //判断左子树
        boolean left = true;
        if(i>0){
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
        }
        //判断右子树
        boolean right = true;
        if(i<sequence.length-1){
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length-1));
        }
        return left&&right;
    }

    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        System.out.println(new Solution().VerifySquenceOfBST(sequence));
    }
}
