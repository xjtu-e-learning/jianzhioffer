package com.elearning.chapter5.interviewquestion29;


/**
 * 面试题29：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {

    /**
     * 方法1：就我想，最少得遍历数组一遍，所以可以考虑最小复杂度O(n)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(IsEmptyArray(array)){
            return 0;
        }
        int result = MoreThanHalfNum(array);
        if(isRealMoreThanHalf(result,array)){
            return result;
        }
        return 0;
    }

    public boolean IsEmptyArray(int[] array){
        if(array==null||array.length==0){
            return true;
        }
        return false;
    }

    public boolean isRealMoreThanHalf(int result,int[] array){
        int cnt = 0;
        for(int i=0;i<array.length;i++){
            if(result==array[i]){
                cnt++;
            }
        }
        if(2*cnt>array.length){
            return true;
        }
        return false;
    }

    public int MoreThanHalfNum(int[] array){
        int record = array[0];
        int value = 1;
        for (int i=1;i<array.length;i++){
            if(value==0){
                record = array[i];
                value = 1;
            }
            else if(record==array[i]){
                value++;
            }
            else {
                value--;
            }
        }
        return record;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,3,3,3,3,3};
        System.out.print(new Solution().MoreThanHalfNum_Solution(array));
    }
}
