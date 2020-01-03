import java.util.Scanner;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/3
 * 19:29
 */
public class arrayCircleQueue {
    public static void main(String[] args) {
        ArrayCircleQueueDemo arrayQueue = new ArrayCircleQueueDemo(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key;
        while (loop) {
            System.out.println("s:显示整个队列");
            System.out.println("q:退出");
            System.out.println("p:显示第一个元素");
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
                case 'p':
                    try {
                        int p = arrayQueue.peak();
                        System.out.printf("取出的数据为：%d\n", p);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int g = arrayQueue.get();
                        System.out.printf("取出的数据为：%d\n", g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数字");
                        int i = scanner.nextInt();
                        arrayQueue.add(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

    public static class ArrayCircleQueueDemo {
        private int maxsize;
        private int head;
        private int tail;
        private int[] arr;

        //构造函数
        public ArrayCircleQueueDemo(int maxsize) {
            this.maxsize = maxsize;
            head = 0;//指针指向队首
            tail = 0;//指针指向队列尾部的后一个位置
            arr = new int[maxsize];
        }

        //判断是否为空
        public boolean isEmpty() {
            return tail == head;
        }

        //判断是否已满
        public boolean isFull() {
            return (tail + 1) % maxsize == head;
        }

        //添加数据
        public void add(int i) {
            if (isFull()) {
                throw new RuntimeException("数组已满");
            }
            arr[tail] = i;
            tail=(tail+1)%maxsize;
        }

        //获取数据
        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("数组已空");
            }
            int g = arr[head];
            head=(head+1)%maxsize;
            return g;
        }

        //得到数据（不出列）
        public int peak() {
            if (isEmpty()) {
                throw new RuntimeException("数组已空");
            }
            return arr[head];
        }

        //显示数据
        public void show() {
            if (isEmpty()) {
                System.out.println("队列为空，没有数据");
                return;
            }
            for (int i = head; i < head+num(); i++) {
                System.out.printf("arr[%d]=%d\n", i%maxsize, arr[i%maxsize]);
            }
        }
        //队列中数据的个数
        public int num(){
            return (tail+maxsize-head)%maxsize;
        }
    }
}
