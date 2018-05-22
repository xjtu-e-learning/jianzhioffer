package com.elearning.chapter2.interviewquestion3_arraysearch;

/**
 * 面试题3：二维数组中的查找
 * @author yangkuan
 */
public class TwoDimensionalArray {
    /**
     * 在一个二维数组中，每一行都从左到右递增，每一列都从上到下递增
     * 在数组中查找一个数，判断其是否存在
     * @param matrix 二维矩阵
     * @param number 要查找的数
     * @return 查找到返回true，否则false
     */
    public static boolean findNumberInMatrix(Integer[][] matrix, Integer number){
        int colSize = matrix[0].length;
        int rowSize = matrix.length;
        //从右上角开始查找，
        int rowIndex = 0;
        int colIndex = colSize - 1;
        while ((rowIndex<rowSize)&&(colIndex>=0)){
            //如果小于横着走
            if(number<matrix[rowIndex][colIndex]){
                colIndex --;
            }
            //如果大于竖着走
            else if(number>matrix[rowIndex][colIndex]){
                rowIndex ++;
            }
            else {
                return true;
            }
        }
        //未找到
        return false;
    }
    public static void main(String[] args){
        Integer[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Integer number = 1;

        System.out.println(findNumberInMatrix(matrix, number));
    }
}
