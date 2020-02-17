import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 16:22
 * 是不稳定排序
 */
public class ShellSort {
    public static void main(String[] args) {
        //希尔排序的实现，是插入排序的优化算法
        int[] arr = {1, 2, 5, 3, 5, 4, 3, 1};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp;
        //gap为增量，（可以改变），由大向小进行循环，直到增量为1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //找出每一组的第一个数
            for (int j = 0; j < gap; j++) {
                //找出一组中的所有数并进行比较
                for (int k = j+gap; k < arr.length; k += gap) {
                    //交换法的实现,代码有误，此处应是暴力求解，需两层循环
                    if (arr[k]<arr[k-gap]) {
                        temp = arr[k - gap];
                        arr[k - gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
    }

    //希尔排序的优化
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //每组的第一个元素
            for (int j = 0; j < gap; j++) {
                for (int k = j + gap; k < arr.length; k += gap) {
                    //内部采用插入排序(模仿插入排序，进行改写）
                    int tempValue = arr[k];
                    for (int i = k; i >= j; i -= gap) {
                        if (i > j && tempValue < arr[i-gap]) {
                            arr[i] = arr[i- gap];
                        } else {
                            arr[i] = tempValue;
                            break;
                        }
                    }
                }
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
