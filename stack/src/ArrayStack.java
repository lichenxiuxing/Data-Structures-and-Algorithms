import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/6
 * 8:58
 */
public class ArrayStack {
    public static void main(String[] args) {
        //栈的演示
        ArrayStackDemo arrayStackDemo=new ArrayStackDemo(3);
        String key;
        boolean flag=true;
        Scanner scanner=new Scanner(System.in);
        while (flag){
            System.out.println("exit:退出");
            System.out.println("show:显示元素");
            System.out.println("pop:弹出");
            System.out.println("push:压入");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "pop":
                    try{
                        arrayStackDemo.pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入压入的数字");
                    int i=scanner.nextInt();
                    arrayStackDemo.push(i);
                    break;
                case "exit":
                    scanner.close();
                    flag=false;
                    System.out.println("程序已退出");
                    break;
                case "show":
                    arrayStackDemo.show();
                    break;
            }

        }

    }
}
class ArrayStackDemo{
    private int maxsize;
    private int top;
    private int[] array;
    //构造函数
    public ArrayStackDemo(int maxsize) {
        this.maxsize = maxsize;
        this.top=-1;
        array=new int[maxsize];
    }
    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断是否已满
    public boolean isFull(){
        return top==maxsize-1;
    }
    //pop方法
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int i=array[top];
        top--;
        return i;
    }
    //push方法
    public void push(int i){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        array[top]=i;
    }
    //list方法
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i=top;i>=0;i--){
            System.out.printf("栈中元素依次为array[%d]=%d\n",i,array[i]);
        }
    }
}
