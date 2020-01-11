import sun.font.FontRunIterator;

import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 16:22
 */
public class ShellSort {
    public static void main(String[] args) {
        //希尔排序的实现，是插入排序的优化算法
        int[] arr = {1, 2, 5, 3, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        //将待排序的数组进行分组,随着次数增加，分的组也随之增加，倍率为2,其中i为步长,也是组数
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //先进行步长循环,得到每组中包含的元素，分成不同的组。
            //所有组同时进行比较（并非比完一组，再比另一组），循环增加的既是组中的元素，也是不同的组
            for (int j = i; j < arr.length; j++) {
                //同组内的元素进行交换比较
                for (int k = j - i; k >= 0; k -= i) {
                    //交换法的实现
                    if (arr[k + i] < arr[k]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }

    //希尔排序的优化
    public static void shellSort2(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //内部采用插入排序
            for (int j = i; j < arr.length; j++) {
                int tempValue = arr[j];
                while (j - i >= 0 && tempValue < arr[j - i]) {
                    arr[j] = arr[j - i];
                    j -= i;
                }
                arr[j] = tempValue;

            }
        }
    }

    //暴力排序
    public static void baoliSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
