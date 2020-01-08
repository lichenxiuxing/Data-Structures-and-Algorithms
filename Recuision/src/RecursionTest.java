import javax.sound.midi.Soundbank;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/8
 * 15:18
 */
public class RecursionTest {
    public static void main(String[] args) {
        int n=fit(5);
        System.out.println(n);
    }
    //递归问题：1、将结果直接返回，2、有sout语句，否则结果无法保留
    public static int fit(int n){
        if (n==1){
            return 1;
        }else{
            return fit(n-1)*n;
        }
    }
}
