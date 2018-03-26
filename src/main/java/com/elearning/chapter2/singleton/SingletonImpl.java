package com.elearning.chapter2.singleton;

public class SingletonImpl {
    private SingletonImpl(){

    }
    private static SingletonImpl instance = new SingletonImpl();
    public static SingletonImpl getInstance(){
        if(instance!=null){
            return instance;
        }
        instance = new SingletonImpl();
        return instance;
    }
}
