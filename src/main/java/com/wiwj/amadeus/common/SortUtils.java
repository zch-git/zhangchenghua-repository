package com.wiwj.amadeus.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
* @Description   :  java排序算法
* @Author        :  Amadeus
* @CreateDate    :  2020/9/8 15:11
* @UpdateUser    :  Amadeus
* @UpdateDate    :  2020/9/8 15:11
* @UpdateRemark  :  修改内容
* @Version       :  1.0
*/
@Slf4j
public class SortUtils {

    /**
     *   1.冒泡排序
     *   时间复杂度-> 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * @author Amadeus
     * @param array :  
     * @return int[]
     * @date 2020/9/8 15:37
     */
    public static int[] bubbleSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        for(int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - i; j++){
                if (array[j + 1] < array[j]){
                    array[j + 1] = array[j + 1] + array[j];
                    array[j] = array[j + 1] - array[j];
                    array[j + 1] = array[j + 1] - array[j];
                }
            }
        }
        return array;
    }

    /**
     * 2.选择排序
     * 时间复杂度-> 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/8 16:11
     */
    public static int[] selectionSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        for (int i = 0; i < array.length; i++){
            //记录最小数的下标
            int minIndex = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[minIndex]){//遍历找出最小数
                    minIndex = j;
                }
            }
            //将最小的数依次放在最前面，交换两个数的位置
            array[i] = array[i] + array[minIndex];
            array[minIndex] = array[i] - array[minIndex];
            array[i] = array[i] - array[minIndex];
        }
        return array;
    }

    /**
     *  3.插入排序
     *  时间复杂度-> 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/8 16:47
     */
    public static int[] insertionSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        //初始化当前需要插入的数据
        int current;
        //初始化已经排序好的最后一个数的下标
        int preIndex;
        for (int i = 0; i < array.length - 1; i++){
            current = array[i + 1];//当前需要往前插入的数据
            preIndex = i;//记录已经排序好的最后一个数的下标
            while(preIndex >= 0 && current < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            //正确的将需要插入的数插入到指定位置
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     *   4.希尔排序
     *   时间复杂度-> 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:34
     */
    public static int[] shellSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        int length = array.length;
        int temp,preIndex,gap = length / 2;
        while (gap > 0){
            for (int i = gap; i < length;i++){
                temp = array[i];//初始化需要插入的数据
                preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     *  5.归并排序
     *  时间复杂度-> 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:56
     */
    public static int[] mergeSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     *  归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @author Amadeus
     * @param left :
     * @param right :
     * @return int[]
     * @date 2020/9/9 11:19
     */
    private static int[] merge(int[] left, int[] right) {
        //初始化最终输出的排序数组
        int[] result = new int[left.length + right.length];
        for (int index = 0,i = 0,j = 0; index < result.length; index++){
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    /**
     *  6.快速排序
     *  时间复杂度-> 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
     *
     * @author Amadeus
     * @param array : 需要排序的数组
     * @param start : 数组中需要进行排序的第一个数的下标
     * @param end : 数组中需要进行排序的最后一个数的下标
     * @return int[]
     * @date 2020/9/9 14:23
     */
    public static int[] quickSort(int[] array,int start,int end){
        if (array == null || array.length < 2 || start < 0 || end >= array.length || start > end){
            return array;
        }
        int smallIndex = partition(array,start,end);
        if (smallIndex > start)
            quickSort(array,start,smallIndex - 1);
        if (smallIndex < end)
            quickSort(array,smallIndex + 1,end);
        return array;
    }

    /**
     *  快速排序算法-partition
     *
     * @author Amadeus
     * @param array :
     * @param start :
     * @param end :
     * @return int
     * @date 2020/9/9 14:22
     */
    private static int partition(int[] array, int start, int end) {
        //从数组中挑出一个"基准"元素
        int pivot = (int) (start + Math.random() * (end - start + 1));
        //初始化最小数据的下标
        int smallIndex = start - 1;
        swap(array,pivot,end);
        for (int i = start; i <= end; i++){
            if (array[i] <= array[end]){
                smallIndex++;
                if (i > smallIndex)
                    swap(array,i,smallIndex);
            }
        }
        return smallIndex;
    }

    /**
     *  交换数组内的两个元素
     *
     * @author Amadeus
     * @param array :
     * @param pivot :
     * @param end :
     * @return void
     * @date 2020/9/9 14:40
     */
    private static void swap(int[] array, int pivot, int end) {
        array[pivot] = array[pivot] + array[end];
        array[end] = array[pivot] - array[end];
        array[pivot] = array[pivot] - array[end];
    }

    /**
     *  7.堆排序
     *  时间复杂度-> 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:56
     */
    public static int[] heapSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }

        return array;
    }
    /**
     *  8.计数排序
     *  时间复杂度-> 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:56
     */
    public static int[] countingSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }

        return array;
    }
    /**
     *  9.桶排序
     *  时间复杂度-> 最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:56
     */
    public static int[] bucketSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }

        return array;
    }
    /**
     *  10.基数排序
     *  时间复杂度-> 最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
     *
     * @author Amadeus
     * @param array :
     * @return int[]
     * @date 2020/9/9 10:56
     */
    public static int[] radixSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }

        return array;
    }




    public static void main(String[] args) {
        int[] array = {3,2,4,1,0,6,4};
        int[] temp = {13,12,12,2,43,4,24};
//        Arrays.sort(array);
//        Arrays.sort(temp);
        log.info(Arrays.toString(quickSort(array,0,6)));
    }
}
