package com.elearning.chapter5.interviewquestion33;

/**
 * 面试题33：把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author yangkuan
 * @date 2018/07/14 13:35
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] numberStrings = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numberStrings[i]=String.valueOf(numbers[i]);
        }
        quickSort(numberStrings,0,numbers.length-1);
        String result = "";
        for (String numberString:numberStrings) {
            result += numberString;
        }
        return result;
    }

    private int compare(String number1,String number2){
        String number3 = number1+number2;
        String number4 = number2+number1;
        return number3.compareTo(number4);
    }

    private void quickSort(String[] numbers,int beginIndex, int endIndex){
        if (beginIndex<endIndex){
            int midIndex = partition(numbers,beginIndex,endIndex);
            quickSort(numbers,beginIndex,midIndex-1);
            quickSort(numbers,midIndex+1,endIndex);
        }
    }

    private Integer partition(String[] input, int beginIndex, int endIndex){
        int index = beginIndex;
        while (beginIndex!=endIndex){
            while (compare(input[endIndex],input[index])>=0&&beginIndex<endIndex){
                endIndex --;
            }
            while (compare(input[beginIndex],input[index])<=0&&beginIndex<endIndex){
                beginIndex ++;
            }
            if(beginIndex<endIndex){
                swap(input,beginIndex,endIndex);
            }
        }
        swap(input,index,beginIndex);
        return beginIndex;
    }

    private void swap(String[] input, int i, int j){
        String tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(new Solution().PrintMinNumber(numbers));
    }
}
