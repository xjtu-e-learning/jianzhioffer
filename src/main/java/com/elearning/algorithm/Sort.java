package com.elearning.algorithm;

import com.sun.media.sound.RIFFInvalidDataException;

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
            while (index>0&&list[index]<list[index-1]){
                swap(list,index,index-1);
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
    public void shellSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        int gap = 1;
        while (gap<len/3){
            gap = 3*gap+1;
        }
        while (gap>0){
            //插入排序
            for(int i=gap;i<len;i++){
                for (int j=i;j>gap-1&&list[j]<list[j-gap];j-=gap){
                    swap(list,j,j-gap);
                }
            }
            gap = (gap-1)/3;
        }
    }

    /**
     * 堆排序
     * @param list
     */
    public void heapSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        //构建大顶堆
        for(int i=len/2-1;i>=0;i--){
            adjustHeap(list,i,len);
        }
        for(int i=1;i<len;i++){
            swap(list,0,len-i);
            adjustHeap(list,0,len-i);
        }
    }

    /**
     * 调整堆
     * @param list
     * @param index
     * @param len
     */
    private void adjustHeap(int[] list,int index,int len){
        for(int i=2*index+1;i<len;i=2*i+1){
            //寻找较大子节点
            if(i<len-1&&list[i]<list[i+1]){
                i++;
            }
            if(list[index]<list[i]){
                swap(list,index,i);
                index = i;
            }
            else {
                break;
            }
        }
    }

    /**
     * 快速排序
     * @param list
     */
    public void quickSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        quickSortCore(list,0,list.length-1);
    }

    /**
     *
     * @param list
     * @param startIndex
     * @param endIndex
     */
    private void quickSortCore(int[] list,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int left = startIndex;
        int right = endIndex;
        while (left<right){
            while (left<right&&list[left]<=list[endIndex]){
                left++;
            }
            while (right>left&&list[right]>=list[endIndex]){
                right--;
            }
            if(left<right){
                swap(list,left,right);
            }
        }
        swap(list,endIndex,left);
        quickSortCore(list,startIndex,left-1);
        quickSortCore(list,left+1,endIndex);
    }

    /**
     * 归并排序
     * @param list
     */
    public void mergeSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        mergeSortCore(list,0,list.length-1);
    }

    private void mergeSortCore(int[] list,int beginIndex,int endIndex){
        if(beginIndex!=endIndex){
            int mid = (beginIndex+endIndex)/2;
            mergeSortCore(list,beginIndex,mid);
            mergeSortCore(list,mid+1,endIndex);
            merge(list,beginIndex,mid,endIndex);
        }
    }
    private void merge(int[] list,int beginIndex,int midIndex,int endIndex){
        int[] tmp = new int[endIndex-beginIndex+1];
        int left = beginIndex;
        int right = midIndex+1;
        int i=0;
        while (left<=midIndex&&right<=endIndex){
            if(list[left]<list[right]){
                tmp[i++] = list[left++];
            }
            else {
                tmp[i++] = list[right++];
            }
        }
        while (left<=midIndex){
            tmp[i++] = list[left++];
        }
        while (right<=endIndex){
            tmp[i++] = list[right++];
        }
        for(int j=0;j<endIndex-beginIndex+1;j++){
            list[beginIndex+j] = tmp[j];
        }
    }

    /**
     * 计数排序
     * @param list
     */
    public void countSort(int[] list){
        if(list==null||list.length==0){
            return;
        }
        int len = list.length;
        //获取最大最小值
        int min = list[0];
        int max = list[0];
        for(int i=1;i<len;i++){
            if(list[i]<min){
                min = list[i];
            }
            if(list[i]>max){
                max = list[i];
            }
        }
        //初始化次数统计数组
        int[] frequencyList = new int[max-min+1];
        for(int i=0;i<len;i++){
            frequencyList[list[i]-min]++;
        }
        //累加
        for(int i=1;i<frequencyList.length;i++){
            frequencyList[i] += frequencyList[i-1];
        }
        int[] tmp = new int[len];
        for(int i=len-1;i>=0;i--){
            tmp[frequencyList[list[i]-min]-1] = list[i];
            frequencyList[list[i]-min]--;
        }
        for(int i=0;i<len;i++){
            list[i] = tmp[i];
        }
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
        sort.selectSort(list2);
        System.out.print("选择排序：");
        sort.print(list2);

        int[] list3 = {2,4,6,8,2,3,5,1};
        sort.shellSort(list3);
        System.out.print("希尔排序：");
        sort.print(list3);

        int[] list4 = {2,4,6,8,2,3,5,1};
        sort.heapSort(list4);
        System.out.print("堆排序：");
        sort.print(list4);

        int[] list5 = {2,4,6,8,2,3,5,1};
        sort.quickSort(list5);
        System.out.print("快速排序：");
        sort.print(list5);

        int[] list6 = {2,4,6,8,2,3,5,1};
        sort.mergeSort(list6);
        System.out.print("归并排序：");
        sort.print(list6);

        int[] list7 = {2,4,6,8,2,3,5,1};
        sort.countSort(list7);
        System.out.print("计数排序：");
        sort.print(list7);
    }
}
