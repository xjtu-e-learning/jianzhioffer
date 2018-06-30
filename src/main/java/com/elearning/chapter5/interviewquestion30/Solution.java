package com.elearning.chapter5.interviewquestion30;



import java.util.ArrayList;

/**
 * 面试题30：最小的K个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author yangkuan
 * @date 2018/06/29 21:14
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null||input.length<k||input.length<=0||k<=0){
            return new ArrayList<>();
        }
        int start = 0;
        int end = input.length-1;
        int index = partition(input,0,end);
        while (index!=k-1){
            if(index>k-1){
                end = index-1;
                index = partition(input,start,end);
            }
            else {
                start = index+1;
                index = partition(input,start,end);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<=index;i++){
            result.add(input[i]);
        }
        return result;
    }
    private Integer partition(int[] input, int beginIndex, int endIndex){
        int index = beginIndex;
        while (beginIndex!=endIndex){
            while (input[endIndex]>=input[index]&&beginIndex<endIndex){
                endIndex --;
            }
            while (input[beginIndex]<=input[index]&&beginIndex<endIndex){
                beginIndex ++;
            }
            if(beginIndex<endIndex){
                swap(input,beginIndex,endIndex);
            }
        }
        swap(input,index,beginIndex);
        return beginIndex;
    }

    private void swap(int[] input, int i, int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {6,5,4,3,2};
        System.out.print(new Solution().GetLeastNumbers_Solution(input,4));
    }
}
