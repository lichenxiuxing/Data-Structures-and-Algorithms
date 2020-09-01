import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：李晨
 * 创建时间：2020/2/17
 * 20:13
 * 是稳定性排序
 */
public class CountSort {
    public static void main(String[] args) {
        //    int[] arr = {1, 2, 5, 3, 4, 3, 2, 1};
               int[] arr = {1, 2, 5, 3, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countSort(arr)));
    }

    private static int[] countSort(int[] arr) {
        //找出数组中最大和最小元素
        int max=arr[0];
        int min=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        //建立统计数组，用于统计原数组中各个元素所在位置
        int[] countArr=new int[max-min+1];
        for (int i = 0; i < arr.length ; i++) {
            countArr[arr[i]-min]++;
        }
        //重写统计数组，为保证排序方法稳定。此时数组中的数为原数组中元素排序后的顺序
        int sum=0;
        for (int i = 0; i <countArr.length ; i++) {
            sum+=countArr[i];
            countArr[i]=sum;
        }
        //填写有序数组,通过遍历原数组，来保证有序
        int[] sortArr=new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            //countArr[arr[i]-min]得到的是元素的顺序，从1开始，所以要减1
            sortArr[countArr[arr[i]-min]-1]=arr[i];
            countArr[arr[i]-min]--;
        }
        return sortArr;
    }
}
