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
        int[] arr = {1, 2, 5, 3, 4, 3, 2, 1};
        //        int[] arr = {1, 2, 5, 3, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //实现快速排序，递归实现
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    //交换的基本步骤:切分(指针交换法),指针交换法的交换次数更少
    public static int partition(int[] arr, int left, int right) {
        int temp;
        int index = left;
        while (left < right) {
            while (left < right && arr[right] > arr[index]) {
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
    public static void quickSort2(int arr[], int i, int j) {
        if (i < j) {
            int l = i;
            int r = j;
            int pivot = arr[l];
            while (l < r) {
                //直到找到右侧第一个小于pivot的数为止
                while (l < r && arr[r] >= pivot) {
                    r--;
                }
                if (l < r) {
                    arr[l] = arr[r];
                    l++;
                }
                //直到找到左侧第一个大于pivot的数为止
                while (l < r && arr[l] <= pivot) {
                    l++;
                }
                if (l < r) {
                    arr[r] = arr[l];
                }
            }
            //跳出循环时，l==r
            arr[l] = pivot;
            quickSort2(arr, i, l - 1);
            quickSort2(arr, l + 1, j);
        }
    }
}
