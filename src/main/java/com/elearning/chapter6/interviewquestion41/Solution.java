package com.elearning.chapter6.interviewquestion41;

import java.util.ArrayList;

/**
 * 面试题41：和为S的两个数字VS和为S的正整数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 1.输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 2.输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array==null||array.length<2){
            return new ArrayList<>();
        }
        ArrayList<Integer> r = new ArrayList<>();
        int startIndex = 0;
        int endIndex = array.length-1;
        while (startIndex<endIndex){
            if(array[startIndex]+array[endIndex]==sum){
               r.add(array[startIndex]);
               r.add(array[endIndex]);
               return r;
            }
            else if(array[startIndex]+array[endIndex]<sum){
                startIndex++;
            }
            else {
                endIndex--;
            }
        }
        return r;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > r = new ArrayList<>();
        if(sum<3){
            return r;
        }
        int start = 1;
        int end = 2;
        int mid = (sum+1)/2;
        int curSum = start+end;
        while (start<mid){
            if(curSum==sum){
                r.add(saveSequence(start, end));
                start++;
            }
            else if(curSum<sum){
                end++;
            }
            else{
                start++;
            }
            curSum = (start+end)*(end-start+1)/2;
        }
        return r;
    }

    private ArrayList<Integer> saveSequence(int start,int end){
        ArrayList<Integer> sequence = new ArrayList<>();
        for(int i=start;i<=end;i++){
            sequence.add(i);
        }
        return sequence;
    }

    private void test1(){
        int num = 9;
        ArrayList<ArrayList<Integer> > rs = FindContinuousSequence(num);
        for(ArrayList<Integer> r:rs){
            for(Integer i:r){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private void test2(){
        int[] array = {1,2,4,7,11,15};
        int num = 15;
        ArrayList<Integer> r = FindNumbersWithSum(array,num);
        System.out.print(r.get(0)+" "+r.get(1));
    }
    public static void main(String[] args) {
        //new Solution().test2();
        new Solution().test1();
    }
}
