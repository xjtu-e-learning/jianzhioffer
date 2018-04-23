package com.elearning.chapter2.interviewquestion8_rotateingarray;

/**
 * 面试题8：旋转数组的最小数字
 * 二分查找，时间开销O(log n)
 */
public class RotatingArray {

    public int findMin(int[] numbers) throws Exception {
        //首先，旋转数组的特点是，以最小值为分界线
        // 最小值后面的数大于等于最小值
        //最小值前面的数大于等于最小值
        if(numbers==null||numbers.length==0){
            throw new Exception("旋转数组不存在或为空");
        }
        int minNumber;
        int size = numbers.length;
        //设置三个指针，指向起始端，中间，以及末端
        int leftIndex = 0, midIndex = 0, rightIndex = size-1;
        //当起始端大于等于终止端
        while (numbers[leftIndex]>=numbers[rightIndex]){
            if(rightIndex-leftIndex==1){
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex+rightIndex)/2;
            if (numbers[leftIndex]==numbers[midIndex]
                    && numbers[rightIndex]==numbers[midIndex]){
                int minIndex = leftIndex;
                //无法判断位置，顺序查找
                for(int i=leftIndex;i<=rightIndex;i++){
                    if(numbers[midIndex]>numbers[i]){
                        midIndex = i;
                    }
                }
                return numbers[midIndex];
            }
            else if (numbers[leftIndex]<=numbers[midIndex]){
                leftIndex = midIndex;
            }
            else if(numbers[rightIndex]>=numbers[midIndex]){
                rightIndex = midIndex;
            }
        }
        return numbers[midIndex];
    }

    public static void main(String[] args) throws Exception {
        RotatingArray rotatingArray = new RotatingArray();
        int[] numbers = {3,4,5,1,2};
        int min = rotatingArray.findMin(numbers);
        System.out.println(min);
    }

}
