package com.elearning.algorithm;

import java.util.List;

/**
 * 经典排序算法实现
 * @author yangkuan
 */
public class Sort {

    /**
     * 冒泡排序
     * @param list
     */
    public void bubbleSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(list[j]>list[j+1]){
                    swap(list,j,j+1);
                }
            }
        }
    }

    /**
     * 交换
     * @param list
     * @param i
     * @param j
     */
    private void swap(int[] list,int i,int j){
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
    /**
     * 插入排序
     * @param list
     */
    public void insertSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        for(int i=1;i<len;i++){
            int index = i;
            while (index>0){
                if(list[index]<list[index-1]){
                    swap(list,index,index-1);
                }
                index--;
            }
        }
    }

    /**
     * 选择排序
     * @param list
     */
    public void selectSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        for(int i=0;i<len-1;i++){
            int minIndex = i;
            for(int j=i+1;j<len;j++){
                if(list[minIndex]>list[j]){
                    minIndex = j;
                }
            }
            swap(list,i,minIndex);
        }
    }

    /**
     * 希尔排序
     * @param list
     */
    public void shellSort(List<Integer> list){

    }

    /**
     * 堆排序
     * @param list
     */
    public void heapSort(List<Integer> list){

    }

    /**
     * 堆排序
     * @param list
     */
    public void quickSort(List<Integer> list){

    }

    /**
     * 归并排序
     * @param list
     */
    public void mergeSort(List<Integer> list){

    }

    /**
     * 计数排序
     * @param list
     */
    public void countSort(List<Integer> list){

    }

    /**
     * 桶排序
     * @param list
     */
    public void bucketSort(List<Integer> list){

    }

    /**
     * 基数排序
     * @param list
     */
    public void cardinalitySort(List<Integer> list){

    }

    public void print(int[] list){
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] list0 = {2,4,6,8,2,3,5,1};
        sort.bubbleSort(list0);
        System.out.print("冒泡排序：");
        sort.print(list0);

        int[] list1 = {2,4,6,8,2,3,5,1};
        sort.insertSort(list1);
        System.out.print("插入排序：");
        sort.print(list1);

        int[] list2 = {2,4,6,8,2,3,5,1};
        sort.insertSort(list2);
        System.out.print("选择排序：");
        sort.print(list2);
    }
}
