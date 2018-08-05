package com.elearning.chapter3.interviewquestion11_power;

/**
 * 面试题11：数值的整数次方
 * 实现函数 double Power(double base,int exponent
 * @author yangkuan
 * @date 2018/04/21 20:00
 */
public class Power {
    /**
     * 方法1：直接多个数相乘，但是忽略指数小于0问题
     * @param base 基数
     * @param exponent 指数
     * @return
     */
    public double powerByFirstMethod(double base,int exponent){
        double result = 1;
        for(int i=0;i<exponent;i++){
            result *= base;
        }
        return result;
    }

    /**
     * 方法2：直接多个数相乘，并考虑指数小于0问题
     * @param base
     * @param exponent
     * @return
     */
    public double powerBySecondMethod(double base,int exponent) throws Exception{
        if(Double.compare(base,0)==0&&exponent<=0){
            throw new Exception("基数为0时，指数不能同时小于等于0");
        }
        double result = 1;
        if (exponent<0){
            result = 1/powerByFirstMethod(base,-exponent);
        }
        else {
            result = powerByFirstMethod(base,exponent);
        }
        return result;
    }

    /**
     * 指数无符号数
     * @param base
     * @param unsignedExponent
     * @return
     */
    public double powerWithUnsignedExponent(double base,int unsignedExponent){
        if(unsignedExponent==0){
            return 1;
        }
        if(unsignedExponent==1){
            return base;
        }
        double result = 1;
        //判断unsignedExponent的奇偶性
        if((unsignedExponent&1)==0){
            //偶
            unsignedExponent = unsignedExponent >> 1;
            result = powerWithUnsignedExponent(base,unsignedExponent)*powerWithUnsignedExponent(base,unsignedExponent);
        }
        else {
            //奇
            unsignedExponent = unsignedExponent >>1;
            result = powerWithUnsignedExponent(base,unsignedExponent)*powerWithUnsignedExponent(base,unsignedExponent)*base;
        }
        return result;
    }

    /**
     * 方法3：利用a^n = a^(n/2)*a^(n/2)（偶数）或a^(n-1/2)*a^(n-1/2)*a（奇数）
     * @param base
     * @param exponent
     * @return
     */
    public double powerByThirdMethod(double base,int exponent) throws Exception{
        if(Double.compare(base,0)==0&&exponent<=0){
            throw new Exception("基数为0时，指数不能同时小于等于0");
        }
        double result = 1;
        if (exponent<0){
            result = 1/powerWithUnsignedExponent(base,-exponent);
        }
        else {
            result = powerWithUnsignedExponent(base,exponent);
        }
        return result;
    }


    public void testPower(double base,int exponent) throws Exception {
        System.out.println("方法1："+powerByFirstMethod(base,exponent));
        System.out.println("方法2："+powerBySecondMethod(base,exponent));
        System.out.println("方法3："+powerByThirdMethod(base,exponent));
    }

    public static void main(String[] args) throws Exception {
        Power power = new Power();
        power.testPower(2.0,-5);
    }


}
