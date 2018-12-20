package com.elearning.chapter6.interviewquestion44;


import java.util.Arrays;

/**
 * 面试题44：扑克牌的顺序
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @author yangkuan
 */
public class Solution {

    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return false;
        }
        //第一步：排序
        Arrays.sort(numbers);
        //第二步：查看是否有非0重复数字
        for(int i=1;i<numbers.length;i++){
            if(numbers[i-1]!=0&&numbers[i-1]==numbers[i]){
                return false;
            }
        }
        //第三步：计数0
        int cnt0 = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                cnt0++;
            }
            else {
                break;
            }
        }
        //第四步：计数空位
        int cntBlank = 0;
        for (int i=1;i<numbers.length;i++){
            if(numbers[i-1]!=0){
                cntBlank += (numbers[i]-numbers[i-1]-1);
            }
        }
        //第四步：比较
        if(cnt0>=cntBlank){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,0,4,5};
        System.out.println(new Solution().isContinuous(numbers));
    }
}
