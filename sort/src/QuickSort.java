import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 22:13
 */
public class QuickSort {
    public static void main(String[] args) {
        //快速排序也是交换排序的一种
//        int[] arr = {1, 2, 5, 3, 4, 3, 2, 1};
        int[] arr = {1, 2, 5, 3, 4};
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

    //交换的基本步骤:切分(指针交换法)
    public static int partition(int[] arr, int left, int right) {
        int temp;
        //选择基准值
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        int r = pivotIndex + 1;
        //对基准值两端进行调整
        while (left < pivotIndex && r > pivotIndex) {
            while (arr[left] < pivot && left < pivotIndex) {
                left++;
            }
            while (arr[right] > pivot && r > pivotIndex) {
                r++;
            }
            if (arr[left]>arr[right]) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[left] = temp;
            }
        }
        return pivotIndex;
    }
    //挖坑法实现快速排序
}
