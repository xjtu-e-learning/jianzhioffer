package com.elearning.niuke.interviewquestion64;

import java.util.TreeSet;

/**
 * 面试题64：数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author yangkuan
 */
public class Solution {

    private TreeSet<Integer> minHeap = new TreeSet<>();
    private TreeSet<Integer> maxHeap = new TreeSet<>();

    public void Insert(Integer num) {
        //数据流长度偶数,插入最大堆
        if((minHeap.size()+maxHeap.size())%2==0){
            //如果最小堆的最小值比插入值小
            if(minHeap.size()!=0&&minHeap.first()<num){
                minHeap.add(num);
                int minFirst = minHeap.first();
                minHeap.remove(minFirst);
                maxHeap.add(minFirst);
            }
            else {
                maxHeap.add(num);
            }
        }
        //数据流长度奇数,插入最小堆
        else {
            if(maxHeap.size()!=0&&maxHeap.last()>num){
                maxHeap.add(num);
                int maxLast = maxHeap.last();
                maxHeap.remove(maxLast);
                minHeap.add(maxLast);
            }
            else {
                minHeap.add(num);
            }
        }
    }

    public Double GetMedian() {
        if(minHeap.size()==0&&maxHeap.size()==0){
            return 0.0;
        }
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.first()+maxHeap.last())/2.0;
        }
        return (double)maxHeap.last();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert(5);
        //System.out.println(solution.GetMedian());
        solution.Insert(2);
        System.out.println(solution.GetMedian());
        solution.Insert(3);
        System.out.println(solution.GetMedian());
        solution.Insert(4);
        System.out.println(solution.GetMedian());
        solution.Insert(1);
        System.out.println(solution.GetMedian());
        solution.Insert(6);
        System.out.println(solution.GetMedian());
    }

}
