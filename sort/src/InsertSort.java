import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 15:16
 */
public class InsertSort {
    public static void main(String[] args) {
        //插入排序
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
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
}
