package com.elearning.niuke.interviewquestion52;

import java.util.ArrayList;

/**
 * 面试题52：构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author yangkuan
 */
public class Solution {
    public int[] multiply(int[] A) {
        if(A==null||A.length==0){
            return null;
        }
        int product = 1;
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                zeroIndex.add(i);
            }
            product *= A[i];
        }
        int[] B = new int[A.length];
        if(zeroIndex.size()>1){
            for(int i=0;i<A.length;i++){
                B[i] = 0;
            }
        }
        else if(zeroIndex.size()==1){
            for(int i=0;i<A.length;i++){
                B[i] = 0;
            }
            int r = 1;
            for(int i=0;i<A.length;i++){
                if(A[i]!=0){
                    r *= A[i];
                }
            }
            B[zeroIndex.get(0)] = r;
        }
        else {
            for(int i=0;i<A.length;i++){
                B[i] = divide(product,A[i])[0];
            }
        }
        return B;
    }

    /**
     *
     * @param divisor 除数
     * @param dividend 被除数
     * @return 商和余数（保存在数组中）
     */
    private int[] divide(int divisor,int dividend){
        if(dividend==0){
            return null;
        }
        //商
        int quotient = 0;
        //余数
        int remainder = 0;
        int[] result = new int[2];

        boolean flag = (divisor>0)^(dividend>0);
        if(divisor<0){
            divisor = -divisor;
        }
        if(dividend<0){
            dividend = -dividend;
        }

        int divisorBits = 0;
        int divisorTmp = divisor;
        while (divisorTmp!=0){
            divisorTmp = divisorTmp >> 1;
            divisorBits++;
        }
        int dividendBits = 0;
        int dividendTmp = dividend;
        while (dividendTmp!=0){
            dividendTmp = dividendTmp >> 1;
            dividendBits++;
        }
        if(dividendBits<=divisorBits){
            //被除数左移
            dividend = dividend << (divisorBits-dividendBits);
        }
        else {
            quotient = 0;
            remainder = divisor;
            result[0] = quotient;
            result[1] = remainder;
            return result;
        }

        for (int i=0;i<=(divisorBits-dividendBits);i++){
            if(divisor<dividend){
                quotient = (quotient<<1)+0;
                dividend = dividend>>1;
            }
            else {
                quotient = (quotient<<1)+1;
                divisor = divisor - dividend;
                dividend = dividend>>1;
            }
        }
        if(flag){
            result[0] = -quotient;
            result[1] = -divisor;
        }
        else {
            result[0] = quotient;
            result[1] = divisor;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] A = {1,2,0,4,5};
        Solution solution = new Solution();
        int[] B = solution.multiply(A);
        for(int b:B){
            System.out.print(b+" ");
        }
    }
}
