package com.elearning.chapter2.assigmentoperator;

public class CMyString {
    private char[] m_pData;

    public CMyString(char[] pData){
        this.m_pData = pData;
    }
    public CMyString(CMyString cMyString){
        this.m_pData = cMyString.getM_pData();
    }
    public CMyString(){

    }

    public char[] getM_pData() {
        return m_pData;
    }
    public void printInfo(){
        System.out.println(m_pData);
    }

    public static void main(String[] args){
        char[] chars = {'h','e','l','l','o'};
        CMyString a = new CMyString(chars);

        CMyString b = new CMyString(a);
        b.printInfo();

        char[] chars2 = {'h','a','l','l','o'};
        CMyString d = new CMyString(chars2);

        CMyString c = d = a;
        c.printInfo();
        d.printInfo();
    }
}

