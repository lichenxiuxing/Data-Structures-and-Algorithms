import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 16:22
 */
public class ShellSort {
    public static void main(String[] args) {
        //希尔排序的实现
        int[] arr = {1, 2, 5, 3, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        //将待排序的数组进行分组,随着次数增加，分的组也随之增加，倍率为2,其中i为步长,也是组数
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //先进行步长循环,得到每组中包含的元素，分成不同的组。
            for (int j = i; j < arr.length; j += i) {
                //对于每一组，进行组内排序(实际是从每一组的最后向前进行排序）
                for (int k = j-i; k >= 0; k -= i) {
                    //交换法的实现
                    if (arr[k+i] < arr[k]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }
}
