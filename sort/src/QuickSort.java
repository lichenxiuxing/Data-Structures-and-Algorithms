import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 22:13
 * 是不稳定算法
 */
public class QuickSort {
    public static void main(String[] args) {
        //快速排序也是交换排序的一种
        //int[] arr = {1, 2, 5, 3, 4, 3, 2, 1};
        //    int[] arr = {1, 2, 5, 3, 4};
        int[] arr = {-1, 3, 5, 2, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //实现快速排序，递归实现
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //int p = partition(arr, left, right);
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    //交换的基本步骤:切分(指针交换法),指针交换法的交换次数更少
    public static int partition(int[] arr, int left, int right) {
        int temp;
        int index = left;
        while (left < right) {
            while (left < right && arr[right] >= arr[index]) {
                right--;
            }
            //在一开始位置，left==index,所以要加入=，
            while (left < right && arr[left] <= arr[index]) {
                left++;
            }
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        temp = arr[left];
        arr[left] = arr[index];
        arr[index] = temp;
        return left;
    }

    //挖坑法实现快速排序
    public static int partition2(int[] arr, int start, int end) {
        int temp = arr[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] <= temp) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = temp;
        return l;
    }
}
