package src.main.java.com.elearning.chapter3.interviewquestion14reorderoddeven;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author yangkuan
 * @date 2018/05/04
 */
public class ArrayReorder {

    /**
     * 给出两个指针，分别指向头和尾，不断移动，找到头部的偶数和尾部的奇数进行交换
     * 注意：不能保证奇数和奇数，偶数和偶数之间的相对位置不变
     * @param array
     */
    public static void reorderOddEven(int[] array){
        if(array==null){
            return;
        }
        int left = 0;
        int right = array.length-1;
        while (left<right){
            //找偶数，不是偶数右移
            if(!isEven(array[left])){
                left++;
            }
            //找奇数，不是奇数左移
            if(isEven(array[right])){
                right--;
            }
            //左边是偶数，右边是奇数，交换
            if(isEven(array[left])&&!isEven(array[right])){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left ++;
                right --;
            }
        }
    }
    /**
     * 定义新与原数组相等的空间
     * 注意：保证奇数和奇数，偶数和偶数之间的相对位置不变
     * @param array
     */
    public static void reorderOddEvenGuaranteedPosition(int[] array){
        if(array==null){
            return;
        }
        int[] newArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            newArray[i] = array[i];
        }
        //左边起，寻找奇数
        int left = 0;
        for(int i=0;i<array.length;i++){
            if(!isEven(newArray[i])){
                array[left] = newArray[i];
                left ++;
            }
        }
        //右边起，寻找偶数
        int right = array.length-1;
        for(int i=array.length-1;i>=0;i--){
            if(isEven(newArray[i])){
                array[right] = newArray[i];
                right --;
            }
        }
    }


    /**
     * 判断是否为偶数
     * @param number
     * @return 偶数返回true，奇数返回false
     */
    private static boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        return false;
    }

    public static void printList(int[] array){
        if(array==null){
            return;
        }
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        //array = null;
        //reorderOddEven(array);
        reorderOddEvenGuaranteedPosition(array);
        printList(array);
    }
}
