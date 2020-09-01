import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Copyright LiChen
 * 用户：李晨
 * 创建时间：2020/2/17
 * 21:25
 * 是稳定性排序
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] arr = {2.1, 5.2, 3.4, 9.1, 5.6, 8.2};
        System.out.println(Arrays.toString(bucketSort(arr)));
    }

    private static double[] bucketSort(double[] arr) {
        //找出最大最小值
        double max = arr[0];
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        //决定桶排序的关键是1：内部桶的排序方法；2:桶的分配方式
        //初始化桶
        int l = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        //选取桶的个数为原数组中元素个数
        for (int i = 0; i < l; i++) {
            bucketList.add(new LinkedList<>());
        }
        //向桶中添加元素
        double d=max-min;
        for (double v : arr) {
            //给桶进行编号
            int num = (int) ((v - min) / d * (l - 1));
            bucketList.get(num).add(v);
        }
        //将桶中元素进行排序
        for (LinkedList<Double> doubles : bucketList) {
            Collections.sort(doubles);
        }
        //将桶中元素输出
        int num=0;
        double [] sortArr=new double[l];
        for (LinkedList<Double> doubles : bucketList) {
            for (Double aDouble : doubles) {
                sortArr[num++]=aDouble;
            }
        }
        return sortArr;
    }
}
