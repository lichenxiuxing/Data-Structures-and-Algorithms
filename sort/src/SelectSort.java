import java.util.Arrays;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/9
 * 14:23
 */
public class SelectSort {
    public static void main(String[] args) {
        //选择排序
        int[] arr = {-1, 3, 5, 2, 1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        //外部循环，保证从前向后依次进行
        for (int j=0;j<arr.length-1;j++) {
            //此次循环的第一个位置
            int minIndex=j ;
            int min=arr[minIndex];
            //内部循环，每次选择最小的，放在第一个
            for (int i = j+1; i <arr.length ; i++) {
                if(min>arr[i]){
                    minIndex=i;
                    min=arr[minIndex];
                }
            }//选择出最小之后,将其放在第一位
            if (minIndex!=j) {
                arr[minIndex]=arr[j];
                arr[j]=min;
            }
        }
    }
}
