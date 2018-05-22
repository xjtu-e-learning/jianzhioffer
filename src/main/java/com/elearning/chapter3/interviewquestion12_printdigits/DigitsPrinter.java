package com.elearning.chapter3.interviewquestion12_printdigits;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 面试题12：打印1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数
 * 比如输入3，打印1、2、3一直到999
 */
public class DigitsPrinter {
    /**
     * 方法1：需要考虑n过大，从而出现的大数问题，将大数放在数组中
     * @param n
     */
    public void print1ToMaxOfNDigitsByFirstMethod(int n){
        //整型数组存储大数，每一维表示一位
        int[] digit= new int[n+1];
        for(int i=0;i<digit.length;i++){
            digit[i] = 0;
        }
        digit[digit.length-1] = 1;
        //判断大数digit是否达到n+1位，没达到则输出digit
        while (isDigitFull(digit)) {
            printDigit(digit);
            //大数加一
            digit = addDigit(digit);
        }
    }

    /**
     * 大数加一
     * @param digit
     * @return
     */
    public int[] addDigit(int[] digit){
        digit[digit.length-1] += 1;
        //进位判断
        if(digit[digit.length-1]>=10) {
            for(int i=digit.length-2;i>=0;i--){
                digit[i+1] -= 10;
                digit[i] += 1;
                if(digit[i]<10){
                    return digit;
                }
            }
        }
        return digit;
    }

    /**
     * 大数打印
     * @param digit
     */
    public void printDigit(int[] digit){
        boolean flag = false;
        for(int i=0;i<digit.length;i++){
            if(digit[i]!=0){
                flag = true;
            }
            if(flag==true){
                System.out.print(digit[i]);
            }
        }
        System.out.println();
    }

    /**
     * 判断大数是否已经到n位，且满
     * @param digit
     * @return
     */
    public boolean isDigitFull(int[] digit){
        boolean flag = true;
        if(digit[0]==1){
            flag = false;
        }
        return flag;
    }

    /**
     * 方法2:递归输出，用字符数组表示大数
     * @param n
     */
    public void print1ToMaxOfNDigitsBySecondMethod(int n){
        if(n<=0){
            return;
        }
        char[] digit = new char[n];
        for(int i=0;i < 10;i++){
            digit[0] = (char)('0'+i);
            printDigitRecursively(digit,n,1);
        }

    }
    public void printDigitRecursively(char[] digit,int length,int index){
        if(length==index){
            printDigit(digit);
            return;
        }
        for(int i=0;i<10;i++){
            digit[index] = (char)('0'+i);
            printDigitRecursively(digit,length,index+1);
        }
    }
    public void printDigit(char[] digit){
        int not0Index = -1;
        for(int i=0;i<digit.length;i++){
            if(digit[i]!='0'){
                not0Index = i;
                break;
            }
        }
        if(not0Index==-1){
            return;
        }
        for(int i =not0Index;i<digit.length;i++){
            System.out.print(digit[i]);
        }
        System.out.println();
    }

    public void testPrintDigit(int n){
        print1ToMaxOfNDigitsByFirstMethod(n);
        print1ToMaxOfNDigitsBySecondMethod(n);
    }

    public static void main(String[] args) {
        DigitsPrinter digitsPrinter = new DigitsPrinter();
        digitsPrinter.testPrintDigit(2);
    }

}
