package com.elearning.chapter5.interviewquestion35;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35：第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @author yangkuan
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        Map<Character,Integer> container = new HashMap<>(52);
        for(Character ch:str.toCharArray()){
            if(container.get(ch)==null){
                container.put(ch,1);
            }
            else {
                container.put(ch,container.get(ch)+1);
            }
        }
        int i=0;
        for(Character ch:str.toCharArray()){
            if(container.get(ch)==1){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String string = "";
        System.out.println(new Solution().FirstNotRepeatingChar(string));
    }
}
