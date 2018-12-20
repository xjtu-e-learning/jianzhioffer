package com.elearning.niuke.interviewquestion65;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题65：滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> maxNums = new ArrayList<>();
        if(num==null||num.length==0||size>num.length||size==0){
            return maxNums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<num.length;i++){
            if(!queue.isEmpty()){
                if(queue.getFirst()+size<=i){
                    queue.poll();
                }
                while (!queue.isEmpty()&&num[i]>num[queue.getLast()]){
                    queue.removeLast();
                }
            }
            queue.add(i);
            if(i>=size-1){
                maxNums.add(num[queue.getFirst()]);
            }
        }
        return maxNums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(new Solution().maxInWindows(nums,3));
    }
}
