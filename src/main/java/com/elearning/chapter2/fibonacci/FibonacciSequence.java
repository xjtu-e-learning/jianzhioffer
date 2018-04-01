package com.elearning.chapter2.fibonacci;

/**
 * 面试题9：斐波那契数列
 * 分别用递归和循环方法实现
 * 递归会存在重复计算而导致时间开销指数级增长，所以不推荐
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

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.getFibonacciByCirculation(140));
        System.out.println(fibonacciSequence.getFibonacciByRecursion(140));
    }
}
