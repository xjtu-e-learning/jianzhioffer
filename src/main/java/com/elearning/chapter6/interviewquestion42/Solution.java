package com.elearning.chapter6.interviewquestion42;

/**
 * 面试题42：翻转单词顺序VS左旋转字符串
 * 1.左旋转字符串：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 2.翻转单词顺序：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author yangkuan
 */
public class Solution {

    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()<n){
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,chars.length-n-1);
        reverse(chars,chars.length-n,chars.length-1);
        return String.valueOf(chars);
    }

    public String ReverseSentence(String str) {
        if(str==null){
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                endIndex = i-1;
                reverse(chars,startIndex,endIndex);
                startIndex = i+1;
            }
            else if(i==chars.length-1){
                endIndex=i;
                reverse(chars,startIndex,endIndex);
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int startIndex, int endIndex){
        while (startIndex<endIndex){
            char tmp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().LeftRotateString("abcXYZdef",3));
        System.out.println(new Solution().ReverseSentence("I am a student."));
        System.out.println(new Solution().ReverseSentence("student"));
    }
}
