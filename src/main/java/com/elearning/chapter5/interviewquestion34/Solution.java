package com.elearning.chapter5.interviewquestion34;

/**
 * 面试题34：丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author yangkuan
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;

        while (nextUglyIndex<index){
            int min = getMin(uglyNumbers[multiply2Index]*2
                    ,uglyNumbers[multiply3Index]*3
                    ,uglyNumbers[multiply5Index]*5);

            uglyNumbers[nextUglyIndex] = min;

            while (uglyNumbers[multiply2Index]*2<=uglyNumbers[nextUglyIndex]){
                multiply2Index++;
            }
            while (uglyNumbers[multiply3Index]*3<=uglyNumbers[nextUglyIndex]){
                multiply3Index++;
            }
            while (uglyNumbers[multiply5Index]*5<=uglyNumbers[nextUglyIndex]){
                multiply5Index++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[index-1];
    }
    private int getMin(int a, int b, int c){
        int min2 = (a>b)?b:a;
        int min = (min2>c)?c:min2;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().GetUglyNumber_Solution(4)
        );
    }
}
