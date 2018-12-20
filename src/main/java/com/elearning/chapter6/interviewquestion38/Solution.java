package com.elearning.chapter6.interviewquestion38;

/**
 * 面试题38：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * @author yangkuan
 */
public class Solution {

    public int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int firstKIndex = getFirstK(array, k);
        int lastKIndex = getLastK(array, k);
        if(firstKIndex==-1||lastKIndex==-1){
            return 0;
        }
        return lastKIndex-firstKIndex+1;
    }
    private int getFirstK(int[] array, int k){
        int length = array.length;
        int startIndex = 0;
        int endIndex = length-1;
        int midIndex = (startIndex+endIndex)/2;
        int firstKIndex = -1;
        while(startIndex<=endIndex){
            if(array[midIndex]==k){
                if(midIndex==0||array[midIndex-1]!=k){
                    firstKIndex = midIndex;
                    break;
                }
                else{
                    endIndex = midIndex-1;
                    midIndex = (startIndex+endIndex)/2;
                }
            }
            else if(array[midIndex]<k){
                startIndex = midIndex+1;
                midIndex = (startIndex+endIndex)/2;
            }
            else{
                endIndex = midIndex-1;
                midIndex = (startIndex+endIndex)/2;
            }
        }
        return firstKIndex;
    }
    private int getLastK(int[] array, int k){
        int length = array.length;
        int startIndex = 0;
        int endIndex = length-1;
        int midIndex = (startIndex+endIndex)/2;
        int lastKIndex = -1;
        while(startIndex<=endIndex){
            if(array[midIndex]==k){
                if(midIndex==(length-1)||array[midIndex+1]!=k){
                    lastKIndex = midIndex;
                    break;
                }
                else{
                    startIndex = midIndex+1;
                    midIndex = (startIndex+endIndex)/2;
                }
            }
            else if(array[midIndex]>k){
                endIndex = midIndex-1;
                midIndex = (startIndex+endIndex)/2;
            }
            else{
                startIndex = midIndex+1;
                midIndex = (startIndex+endIndex)/2;
            }
        }
        return lastKIndex;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,2,3};
        int  k = 2;
        Solution solution = new Solution();

        System.out.println(solution.getFirstK(array,k));
        System.out.println(solution.getLastK(array,k));
        System.out.print(solution.GetNumberOfK(array,k));
    }
}
