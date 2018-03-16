package com.elearning.chapter2;

public class P2_2 {
    private volatile static P2_2 instance;

    // 构造函数
    private P2_2(){}

    public static P2_2 getInstance()
    {
        // 第一次检验，如果存在实例则跳过加锁过程
        if(instance == null)
        {
            synchronized (P2_2.class)
            {
                // 可能有多个线程同时进入上边的if，再检测一次
                if (instance == null)
                {
                    instance = new P2_2();
                }
            }
        }

        // 如果有实例，返回
        return instance;
    }


}
