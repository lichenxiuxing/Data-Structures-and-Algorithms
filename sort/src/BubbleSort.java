import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 12:57
 * 交换次数较多：最好为0（正序），最坏为3n(n-1)/2（逆序）
 * 比较次数少：最好为n-1,最坏为n(n-1)/2
 * 不会破坏稳定性
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 5, 2, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序方法实现,是一种交换排序
    public static void bubbleSort(int[] arr) {
        //每次确定一个数，共n个数，需进行n-1次
        //进行的次数
        boolean flag = true;//用于优化，当数组不再变化时，跳出循环
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            //每次确定的流程：从前向后，依次比较，直到将最大的放在最后
            //指针从0开始，依次比较
            //如果还未结束，则继续进行排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}

