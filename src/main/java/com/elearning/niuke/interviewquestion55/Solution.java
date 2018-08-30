package com.elearning.niuke.interviewquestion55;

import java.util.HashMap;

/**
 * 面试题55：字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author yangkuan
 */
public class Solution {
    String s = "";
    HashMap<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch){
        s += ch;
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        if(s==null||s.length()==0){
            return '#';
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "google";
        for(char ch:s.toCharArray()){
            solution.Insert(ch);
        }
        System.out.print(solution.FirstAppearingOnce());
    }
}
