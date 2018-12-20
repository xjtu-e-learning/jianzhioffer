package com.second.interviewquestion2;

/**
 * 单例模式
 */
public class FirstInstance {
    private static FirstInstance ourFirstInstance = new FirstInstance();

    public static FirstInstance getInstance() {
        return ourFirstInstance;
    }

    private FirstInstance() {
    }
}
