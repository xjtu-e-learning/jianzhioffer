package src.main.java.com.elearning.chapter4.interviewquestion22;

import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author yangkuan
 * @date 2018/05/27
 */
public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null&&popA==null){
            return true;
        }
        int i=0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        //先将压入序列一直压入栈，如果某一次压入元素等于弹出序列元素，那么弹出
        while (i<pushA.length&&j<popA.length){
            stack.push(pushA[i]);
            i++;
            if(stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        //将栈中的元素与剩余弹出序列对应，如果不对应就是false
        while (!stack.empty()){
            if(stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1};
        int[] popA = {1};
        int[] popB = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
