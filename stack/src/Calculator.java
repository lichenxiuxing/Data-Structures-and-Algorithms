import javax.sound.midi.Soundbank;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/6
 * 10:34
 */
public class Calculator {
    public static void main(String[] args) {
        String s = "1-3*2+500";
        ArrayStackDemo2 numStack = new ArrayStackDemo2(10);
        ArrayStackDemo2 perStack = new ArrayStackDemo2(10);
        int index = 0;
        char temp = ' ';
        int res = 0;
        String ns = "";
        for (int i = 0; i < s.length(); i++) {
            temp = s.substring(i, i + 1).charAt(0);
            //判断是否为计算符
            if (isPer(temp)) {
                //判断栈中是否有元素
                if (perStack.isEmpty()) {
                    perStack.push(temp);
                }//不为空的时候
                else {
                    //判断优先级
                    //优先级高时：直接入栈
                    while (priority(temp) <= priority(perStack.peak())) {
                        //优先级低时：先计算，再入栈
                        res = numStack.cal(numStack.pop(), numStack.pop(), perStack.pop());
//                        System.out.println("扫描"+res);
                        numStack.push(res);
                        if (perStack.isEmpty()) {
                            break;
                        }//不为空的时候
                    }
                    perStack.push(temp);
                }
            }//为数字时
            else {
                ns+=temp;
                //判断是否为最后一位
                if (i == s.length() - 1) {
                    int n = Integer.parseInt(ns);
                    numStack.push(n);
                }
                //判断后面是否为符号
                //是符号时
                else {
                    if (isPer(s.substring(i + 1, i + 2).charAt(0))) {
                        int n = Integer.parseInt(ns);
                        numStack.push(n);
                        ns = "";
                    }
                }
            }
        }
        // 扫描完后的出栈工作
        while (true) {
            if (perStack.isEmpty()) {
                System.out.printf(s + "=%d", numStack.pop());
                break;
            }
            res = numStack.cal(numStack.pop(), numStack.pop(), perStack.pop());
//            System.out.println(res);
            numStack.push(res);
        }


    }

    //判断是否是字符
    public static boolean isPer(int ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    //计算符号的优先级
    public static int priority(int ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else {
            return 0;
        }
    }
}

class ArrayStackDemo2 {
    private int maxsize;
    private int top;
    private int[] array;

    //构造函数
    public ArrayStackDemo2(int maxsize) {
        this.maxsize = maxsize;
        this.top = -1;
        array = new int[maxsize];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断是否已满
    public boolean isFull() {
        return top == maxsize - 1;
    }

    //peak方法
    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int i = array[top];
        return i;
    }

    //pop方法
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int i = array[top];
        top--;
        return i;
    }

    //push方法
    public void push(int i) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        array[top] = i;
    }

    //list方法
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈中元素依次为array[%d]=%d\n", i, array[i]);
        }
    }


    //两数之间的计算
    public int cal(int num1, int num2, int ch) {
        int res = 0;
        switch (ch) {
            case '*':
                res = num1 * num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}
