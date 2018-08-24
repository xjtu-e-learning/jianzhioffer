package com.elearning.chapter6.interviewquestion45;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * @author yangkuan
 */
public class Solution {
    class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    /** 构建循环链表
     * 方法1：
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_SolutionFirstMethod(int n, int m) {
        if(n<=0||m<=0){
            return 0;
        }
        //构建循环链表
        Node head = new Node(0);
        Node lastNode = head;
        for(int i=1;i<n;i++){
            Node currentNode = new Node(i);
            lastNode.next = currentNode;
            lastNode = currentNode;
        }
        lastNode.next = head;

        //循环计数
        Node indexNode = lastNode;
        while (indexNode.next!=indexNode){
            //前进m-1步
            for(int i=0;i<m-1;i++){
                indexNode = indexNode.next;
            }
            //删除第m个节点
            indexNode.next = indexNode.next.next;
        }
        return indexNode.val;
    }

    public int LastRemaining_SolutionSecondMethod(int n, int m) {
        if(n<=0||m<=0){
            return 0;
        }
        int f = 0;
        for(int i=2;i<=n;i++){
            f = (f+m)%i;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LastRemaining_SolutionFirstMethod(100,50));
        System.out.println(new Solution().LastRemaining_SolutionSecondMethod(100,50));
    }

}
