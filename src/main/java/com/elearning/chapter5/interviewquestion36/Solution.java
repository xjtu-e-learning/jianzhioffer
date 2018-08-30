package com.elearning.chapter5.interviewquestion36;


/**
 * 面试题36：数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author yangkuan
 */

public class Solution {

    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        return InversePairsCore(array, copy, 0, array.length-1) %1000000007;
    }
    private int InversePairsCore(int[] array, int[] copy, int beginIndex, int endIndex){
        if(beginIndex==endIndex){
            return 0;
        }
        int mid = (endIndex+beginIndex)/2;

        int leftCnt = InversePairsCore(array,copy,beginIndex,mid)%1000000007;
        int rightCnt = InversePairsCore(array,copy,mid+1,endIndex)%1000000007;

        int cnt = 0;
        int i = mid;
        int j = endIndex;
        int t = endIndex;
        while(i>=beginIndex&&j>=(mid+1)){
            if(array[i]<array[j]){
                copy[t--] = array[j--];
            }
            else{
                copy[t--] = array[i--];
                cnt += (j-mid);
                if(cnt>=1000000007){
                    cnt = cnt%1000000007;
                }
            }
        }
        for(;i>=beginIndex;){
            copy[t--] = array[i--];
        }
        for(;j>=(mid+1);){
            copy[t--] = array[j--];
        }
        for(int k=beginIndex;k<=endIndex;k++){
            array[k] = copy[k];
        }
        return leftCnt+rightCnt+cnt;
    }

    public static void main(String[] args) {
         int[] array = {7,6,2,3,4,5};
         int result = new Solution().InversePairs(array);
         System.out.println(result);
         for(int a:array){
             System.out.print(a+" ");
         }
         System.out.println();

//        493330277;
//        1000000007;
//        -801636998;

    }
}