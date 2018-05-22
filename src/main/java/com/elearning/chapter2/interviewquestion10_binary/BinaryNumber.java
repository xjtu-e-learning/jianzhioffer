package com.elearning.chapter2.interviewquestion10_binary;

/**
 * 面试题10：二进制中1的个数
 * @author yangkuan
 * @date 2018/04/21 18:06
 */
public class BinaryNumber {
    /**
     * 方法1：将整数先转换成二进制字符串，再统计1的个数
     * @param binaryNumber
     * @return
     */
    public Integer countOneByFirstMethod(Integer binaryNumber){
        Integer oneCount = 0;
        String binaryString = Integer.toBinaryString(binaryNumber);
        for(int i=0;i<binaryString.length();i++){
            if(binaryString.charAt(i)=='1'){
                oneCount++;
            }
        }
        return oneCount;
    }
    /**
     * 方法2：除2，不断统计1的个数
     * @param binaryNumber
     * @return
     */
    public Integer countOneBySecondMethod(Integer binaryNumber){
        Integer oneCount = 0;
        while (binaryNumber!=0){
            if((binaryNumber&1)==1){
                oneCount++;
            }
            //无符号位移
            binaryNumber = binaryNumber >>> 1;
        }
        return oneCount;
    }
    /**
     * 方法3：定义一个flag，每次左移1位
     * 不好，因为每次都得循环32次
     * @param binaryNumber
     * @return
     */
    public Integer countOneByThirdMethod(Integer binaryNumber){
        Integer flag = 1;
        Integer oneCount = 0;
        while (flag!=0){
            if((flag&binaryNumber)!=0){
                oneCount++;
            }
            flag = flag<<1;
        }
        return oneCount;
    }

    /**
     * 方法4：数字减1，与原数按位与
     * @param binaryNumber
     * @return
     */
    public Integer countOneByForthMethod(Integer binaryNumber){
        Integer oneCount = 0;
        while (binaryNumber!=0){
            binaryNumber = (binaryNumber-1)&binaryNumber;
            oneCount++;
        }
        return oneCount;
    }

    public void testCountOne(Integer binaryNumber){
        System.out.println("方法1："+countOneByFirstMethod(binaryNumber));
        System.out.println("方法2："+countOneBySecondMethod(binaryNumber));
        System.out.println("方法3："+countOneByThirdMethod(binaryNumber));
        System.out.println("方法4："+countOneByForthMethod(binaryNumber));
    }

    public static void main(String[] args) {
        BinaryNumber binaryNumber = new BinaryNumber();
        //最大正数
        binaryNumber.testCountOne(0x7FFFFFFF);
        //-1
        binaryNumber.testCountOne(0xFFFFFFFF);
        //最小负数
        binaryNumber.testCountOne(0x80000000);
    }



}
