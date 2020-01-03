import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.jmx.snmp.internal.SnmpOutgoingRequest;
import org.omg.SendingContext.RunTime;

import java.util.Scanner;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/3
 * 16:34
 */
public class arrayQueue {
    public static void main(String[] args) {
        ArrayQueueDemo arrayQueue = new ArrayQueueDemo(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key;
        while (loop) {
            System.out.println("s:显示整个队列");
            System.out.println("q:退出");
            System.out.println("h:显示第一个元素");
            System.out.println("g:获取第一个元素");
            System.out.println("a:添加元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.show();
                    break;
                case 'q':
                    scanner.close();
                    System.out.println("已经退出\n");
                    loop = false;
                    break;
                case 'h':
                    try {
                        arrayQueue.peak();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int g = arrayQueue.get();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    try {
                        int i = scanner.nextInt();
                        arrayQueue.add(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

    public static class ArrayQueueDemo {
        private int maxsize;
        private int head;
        private int tail;
        private int[] arr;

        //构造函数
        public ArrayQueueDemo(int maxsize) {
            this.maxsize = maxsize;
            head = -1;//指针指向队首的前一个位置
            tail = -1;//指针指向队列的尾部
            arr = new int[maxsize];
        }

        //判断是否为空
        public boolean isEmpty() {
            return tail == head;
        }

        //判断是否已满
        public boolean isFull() {
            return tail == maxsize - 1;
        }

        //添加数据
        public void add(int i) {
            if (isFull()) {
                throw new RuntimeException("数组已满");
            }
            tail++;
            arr[tail] = i;
        }

        //获取数据
        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("数组已空");
            }
            head++;
            int a = arr[head];
            return a;
        }

        //得到数据
        public void peak() {
            if (isEmpty()) {
                new Exception("数组已空");
            }
            int a = arr[head+1];
            System.out.println("排在队首的元素为"+a);
        }

        //显示数据
        public void show() {
            if (isEmpty()) {
                throw new RuntimeException("数组已空");
            }
            for (int i=0;i<arr.length;i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
    }
}
