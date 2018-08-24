package com.elearning.chapter7.interviewquestion49;

/**
 * 面试题49：把字符串转换为整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * @author yangkuan
 */
public class Solution {
    /**
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str==null||str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int positive = 1;
        int index = 0;
        if(chars[0]=='+'){
            index++;
        }else if(chars[0]=='-'){
            positive=-1;
            index++;
        }
        int value = 0;
        for(int i=index;i<chars.length;i++){
            if(chars[i]>'9'||chars[i]<'0'){
                return 0;
            }
            value = value*10+(chars[i]-'0');
        }
        return value*positive;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("123"));
        System.out.println(new Solution().StrToInt("+123"));
        System.out.println(new Solution().StrToInt("-123"));
        System.out.println(new Solution().StrToInt(""));
        System.out.println(new Solution().StrToInt("+"));
        System.out.println(new Solution().StrToInt("-"));
        System.out.println(new Solution().StrToInt("as"));
        System.out.println(new Solution().StrToInt(null));
        System.out.println(new Solution().StrToInt("12231213213213321231"));
    }
}
