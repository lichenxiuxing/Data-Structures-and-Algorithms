import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：李晨
 * 创建时间：2020/2/17
 * 18:25
 * 归并排序是稳定性排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 4, 3, 2, 1};
        //        int[] arr = {1, 2, 5, 3, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //分而治之：分
    private static void mergeSort(int[] arr, int l, int r) {
        //先做拆分
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    //分而治之：治和并
    //其实并未将元素组进行真实分割，只是抽象的分割，数组中元素仍在原数组中。
    private static void merge(int[] arr, int l, int mid, int r) {
        //创建一个临时数组
        int[] tempArr = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int p = 0;
        //将两数组中元素进行排序并放入临时数组
        while (p1 <= mid && p2 <= r) {
            //加入等号是稳定性排序
            if (arr[p1] <= arr[p2]) {
                tempArr[p++] = arr[p1++];
            } else {
                tempArr[p++] = arr[p2++];
            }
        }
        //将剩余元素直接放入临时数组
        while (p1 <= mid) {
            tempArr[p++] = arr[p1++];
        }
        while (p2 <= r) {
            tempArr[p++] = arr[p2++];
        }
        //将临时数组元素放入原数组
        for (int i = 0; i < tempArr.length; i++) {
            arr[l + i] = tempArr[i];
        }
    }
}
