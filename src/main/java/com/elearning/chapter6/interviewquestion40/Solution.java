package com.elearning.chapter6.interviewquestion40;

/**
 * 面试题40：数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * @author yangkuan
 */
public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2){
            return;
        }
        int xor = 0;
        //数组异或
        for(int i=0;i<array.length;i++){
            xor = xor^array[i];
        }
        num1[0] = 0;
        num2[0] = 0;
        int indexBit = findFirstBitIs1(xor);
        for(int i=0;i<array.length;i++){
            if(isBit1(array[i],indexBit)){
                num1[0] = num1[0]^array[i];
            }
            else {
                num2[0] = num2[0]^array[i];
            }
        }
    }
    private Integer findFirstBitIs1(Integer number){
        int indexBit = 0;
        while ((number&1)==0){
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }

    private boolean isBit1(int number, int indexBit){
        number = number >> indexBit;
        return (number&1)==1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {2,4,3,6,3,2,5,5};
        new Solution().FindNumsAppearOnce(array,num1, num2);
        System.out.print(num1[0]+ " " +num2[0]);
    }
}
