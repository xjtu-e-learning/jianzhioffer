package com.elearning.chapter6.interviewquestion46;

/**
 * 面试题46：求1+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author yangkuan
 */
public class Solution {
    /**
     * 递归的方法
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        if(n==0){
            return 0;
        }
        return n+Sum_Solution(n-1);
    }
}
