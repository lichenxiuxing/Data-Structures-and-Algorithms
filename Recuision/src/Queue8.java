import javax.sound.midi.Soundbank;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/8
 * 16:57
 */
public class Queue8 {
    public static void main(String[] args) {
        Queue8 queue8=new Queue8();
        queue8.check(0);
    }

    private final int max = 8;
    private int[] array = new int[8];


    //检查有多少种
    private void check(int n){
        if (n==8){
            print();
            return;
        }
        for (int i = 0; i <max ; i++) {
            //先按照行循环来放置
            array[n]=i;
            //判断是否与之前冲突
            if (judge(n)){
                check(n+1);
            }
        }
    }
    //判断queue是否会死亡
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[i] - array[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    //打印数组的方法
    private void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
