package com.elearning.chapter5.interviewquestion32;


import java.util.Date;

/**
 * 面试题32：从1到n整数中1出现的次数
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author yangkuan
 */
public class Solution {
    /**
     * 不好的方法，时间复杂度O(n*log(n))
     * 拿不到offer
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_SolutionNotGood(int n) {
        //求余数
        int cnt = 0;
        for(int i=1;i<=n;i++){
            int number = i;
            while (number!=0){
                int remainder = number%10;
                number = number/10;
                if(remainder==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 好方法，拿offer
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_SolutionVeryGood(int n) {
        return countOne(n);
    }

    private int countOne(int n){
        if (n==0){
            return 0;
        }
        //首先你得看n有几位数
        String number = Integer.toString(n);
        int length = number.length();
        //求去除最高位的余数
        int remainder = n%(pow(length-1));
        //求最高位
        int first = number.charAt(0)-'0';
        //例如n=5，求0-49999
        int cntFirst = 0;
        if(number.charAt(0)=='1'){
            cntFirst = remainder+1;
        }else if(number.charAt(0)>'1'){
            cntFirst = pow(length-1);
        }
        //11111
        int cntOne = first * (length-1) * pow(length-2);
        //递归求解余数中1的个数
        int cntRemainder = countOne(remainder);
        return cntFirst+cntOne+cntRemainder;
    }
    private int pow(int length){
        int r = 1;
        for(int i=0;i<length;i++){
            r *= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new Solution().NumberOf1Between1AndN_SolutionNotGood(111111111));
        Date date1  = new Date();
        //时间间隔
        System.out.println(date1.getTime()-date.getTime());
        System.out.println(new Solution().NumberOf1Between1AndN_SolutionVeryGood(111111111));
        Date date2  = new Date();
        //时间间隔
        System.out.println(date2.getTime()-date1.getTime());
    }
}
