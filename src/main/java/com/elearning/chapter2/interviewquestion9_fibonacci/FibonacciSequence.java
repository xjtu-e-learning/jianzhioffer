package com.elearning.chapter2.interviewquestion9_fibonacci;

/**
 * 面试题9：斐波那契数列
 * 分别用递归和循环方法实现
 * 递归会存在重复计算而导致时间开销指数级增长，所以不推荐
 * @author yangkuan
 * @date 2018/04/01 21:15
 */
public class FibonacciSequence {
    /**
     * 递归方法实现
     */
    public int getFibonacciByRecursion(int n){
        if(n == 0||n == 1){
            return n;
        }
        return getFibonacciByRecursion(n-1)+getFibonacciByRecursion(n-2);
    }
    /**
     * 循环方法实现
     */
    public int getFibonacciByCirculation(int n){
        if(n == 0){
            return n;
        }
        int fibonacciValue = 1;
        int fibonacciLastValue = 0;
        int i = 1;
        while (i < n){
            int tmp = fibonacciValue;
            fibonacciValue = fibonacciLastValue + fibonacciValue;
            fibonacciLastValue = tmp;
            i++;
        }
        return fibonacciValue;
    }
    //青蛙跳1或2级
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        }
        int value = 1;
        int lastValue = 1;
        int i = 1;
        while(i<target){
            int tmp = value;
            value = value + lastValue;
            lastValue = tmp;
            i ++;
        }
        return value;
    }
    //青蛙跳1,2,3，....,n级
    public int JumpFloorII(int target) {
        // 2^(target-1)
        int result = 1;
        for(int i=1;i<target;i++){
            result = result*2;
        }
        return result;
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }
        int value = 1;
        int lastValue = 1;
        int i = 1;
        while(i<target){
            int tmp = value;
            value = value + lastValue;
            lastValue = tmp;
            i ++;
        }
        return value;
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.getFibonacciByCirculation(140));
        System.out.println(fibonacciSequence.getFibonacciByRecursion(140));
    }
}
