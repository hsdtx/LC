package com.company.review;

import java.util.Arrays;

public class Sort {

    /**
     * 交换
     */
    private static void swap(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    /**
     * 冒泡排序
     * @param list
     * @return
     */
    public static int[] bubbleSort(int[] list){
        for (int i=0; i<list.length; i++){
            for (int j=i+1; j<list.length; j++){
                if (list[i] > list[j]){
                    swap(list, i, j);
                }
            }
        }

        return list;
    }

    /**
     * 选择排序
     * @return
     * @param list
     */
    public static int[] selectSort(int[] list){
        for (int i=0; i<list.length; i++){
            int min = list[i];
            int minIndex = i;
            for (int j=i; j<list.length; j++){
                if (min > list[j]){
                    min = list[j];
                    minIndex = j;
                }
            }

            if (i!=minIndex){
                swap(list, i, minIndex);
            }
        }

        return list;
    }

    /**
     * 插排
     * @param list
     * @return
     */
    public static int[] insertSort(int[] list){
        for (int i=0; i<list.length; i++){
            for (int j=i+1; j>0 && j<list.length && list[j] < list[j-1]; j--){
                swap(list, j, j-1);
            }
        }

        return list;
    }

    /**
     * 归并排序，分治法
     * @return
     */
    public static void mergeSort(int[] list, int[] reg, int begin, int end){
        int length = end - begin + 1;
        //退出递归的条件
        if (length <= 1){
            return ;
        }
        int middle = begin + length / 2;
        mergeSort(list, reg, begin, middle-1);
        mergeSort(list, reg, middle, end);
        merge(list, reg, begin, middle-1, middle, end);
    }

    private static void merge(int[] list, int[] reg, int leftBegin, int leftEnd, int rightBegin, int rightEnd){
//        System.out.println(leftBegin + " " + leftEnd + " " + rightBegin + " " + rightEnd + "\n");
        int i = leftBegin;
        for (; leftBegin <= leftEnd || rightBegin <= rightEnd; i++){
            if (list[leftBegin] < list[rightBegin]){
                reg[i] = list[leftBegin];
                leftBegin++;
            }else {
                reg[i] = list[rightBegin];
                rightBegin++;
            }
        }

        for (; i>leftBegin; i--){
            list[i-1] = reg[i-1];
        }
    }

    public static void quickSort(int[] list, int begin, int end){
        if (begin >= end) return ; //退出递归

        int i = begin + 1, j = end;
        while(i <= j){
            if (list[i] < list[begin]){
                i++;
            }else if(list[j] > list[begin]){
                j--;
            }else{
                swap(list, i, j);
            }
        }

        swap(list, j, begin);
        System.out.println(Arrays.toString(list));
        quickSort(list, begin, j-1);
        quickSort(list, j+1, end);
    }
}
