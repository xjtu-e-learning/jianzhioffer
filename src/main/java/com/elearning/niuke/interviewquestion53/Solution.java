package com.elearning.niuke.interviewquestion53;

/**
 * 面试题53：正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author yangkuan
 */
public class Solution {
    /**
     * 动态规划的方法
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null){
            return false;
        }
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;
        for(int i=str.length;i>=0;i--){
            for (int j=pattern.length-1;j>=0;j--){
                if(j+1==pattern.length||pattern[j+1]!='*'){
                    dp[i][j] = (i!=str.length)&&(str[i]==pattern[j]||pattern[j]=='.')&&dp[i+1][j+1];
                    continue;
                }
                //考虑：*表示1个以上
                int index = i;
                while (index<str.length&&(str[index]==pattern[j]||pattern[j]=='.')){
                    if(dp[index+1][j+2]){
                        dp[i][j]=true;
                        break;
                    }
                    index++;
                }
                //考虑：*表示0
                dp[i][j] = dp[i][j]==true?true:dp[i][j+2];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.print(new Solution().match("a".toCharArray(),"ab*c".toCharArray()));
    }
}
