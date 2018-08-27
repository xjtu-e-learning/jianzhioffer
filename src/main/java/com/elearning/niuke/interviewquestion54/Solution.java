package com.elearning.niuke.interviewquestion54;

import java.util.ArrayList;

/**
 * 面试题54：表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author yangkuan
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        return split(str);
    }
    private boolean split(char[] str){
        ArrayList<Character> coefficient = new ArrayList<>();
        ArrayList<Character> exponent = new ArrayList<>();
        int exponentIndex = -1;
        for(int i=0;i<str.length;i++){
            if(str[i]=='e'||str[i]=='E'){
                exponentIndex = i;
                break;
            }
            coefficient.add(str[i]);
        }
        if(exponentIndex==-1){
            return isInteger(coefficient)||isDecimal(coefficient);
        }
        for(int i=exponentIndex+1;i<str.length;i++){
            exponent.add(str[i]);
        }
        return (isInteger(coefficient)||isDecimal(coefficient))&&(isInteger(exponent));
    }
    private boolean isInteger(ArrayList<Character> str){
        if(str==null||str.size()==0){
            return false;
        }
        int index = 0;
        if(str.get(0)=='+'||str.get(0)=='-'){
            index++;
        }
        ArrayList<Character> chars = new ArrayList<>();
        for(int i=index;i<str.size();i++){
            chars.add(str.get(i));
        }
        return isNumber(chars);
    }
    private boolean isNumber(ArrayList<Character> str){
        /*if(str==null||str.size()==0){
            return false;
        }*/
        for(int i=0;i<str.size();i++){
            if(str.get(i)>'9'||str.get(i)<'0'){
                return false;
            }
        }
        return true;
    }
    private boolean isDecimal(ArrayList<Character> str){
        if(str==null||str.size()==0){
            return false;
        }
        int index = 0;
        if(str.get(0)=='+'||str.get(0)=='-'){
            index++;
        }
        ArrayList<Character>  integerPart = new ArrayList<>();
        ArrayList<Character> decimalPart = new ArrayList<>();
        int decimalIndex = -1;
        for(int i=0;i<str.size();i++){
            if(str.get(i)=='.'){
                decimalIndex = i;
                break;
            }
            integerPart.add(str.get(i));
        }
        if(decimalIndex==-1){
            return isInteger(integerPart);
        }
        for(int i=decimalIndex+1;i<str.size();i++){
           decimalPart.add(str.get(i));
        }
        return isInteger(integerPart)&&isNumber(decimalPart);
    }

    public static void main(String[] args) {
        System.out.print(new Solution().isNumeric("-.123".toCharArray()));
    }
}
