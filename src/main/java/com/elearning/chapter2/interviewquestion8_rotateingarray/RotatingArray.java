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

    public int minNumberInRotateArray(int [] array) {
        //二分查找
        //首先判断数组是否为空
        if(array.length==0||array==null){
            //相应处理
        }
        int left = 0;
        int right = array.length-1;
        int mid = array.length/2;
        while ((right-left)>1){
            //如果三者相等，只能遍历
            if(array[mid]==array[right]&&array[mid]==array[left]){
                int min = array[left];
                for(int i= left+1;i<right;i++){
                    if(min>array[i]){
                        min = array[i];
                    }
                }
                return min;
            }
            else if(array[mid] >= array[left]){
                left = mid;
            }
            else if(array[mid] <= array[right]){
                right = mid;
            }
            //偏向右边
            mid = (left+right+1)/2;
        }
        return array[mid];
    }

    public static void main(String[] args) throws Exception {
        RotatingArray rotatingArray = new RotatingArray();
        int[] numbers = {3,3,3,1,3};
        int min = rotatingArray.findMin(numbers);
        System.out.println(min);
        System.out.println(rotatingArray.minNumberInRotateArray(numbers));
    }

}
