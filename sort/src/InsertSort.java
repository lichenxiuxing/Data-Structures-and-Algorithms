import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 15:16
 * 比较次数：最好为n-1,最坏为n(n-1)/2
 * 交换次数：最好为0,zuih
 * 不会破坏稳定性
 */
public class InsertSort {
    public static void main(String[] args) {
        //插入排序
        int[] arr = {1, 2, 5, 3, 5, 4, 3, 1};
        System.out.println(Arrays.toString(arr));
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序的实现方法
    public static void insertSort(int[] arr) {
        //外圈循环，共进行n-1次，但从1开始
        int insertValue;
        int insertBegin;
        for (int i = 1; i < arr.length; i++) {
            //设置内部循环开始的位置,将待插入的值取出，单独存储
            insertValue = arr[i];
            //待插入值的前一个位置
            insertBegin = i - 1;
            //将待插入的数与前面的数依次比较，直到大于某个数为止
            while (insertBegin >= 0 && insertValue < arr[insertBegin]) {
                //将比较过的数向后移动
                arr[insertBegin + 1] = arr[insertBegin];
                insertBegin--;
            }
            //比较完毕后，将待插入值进行插入
            arr[insertBegin + 1] = insertValue;
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
}
