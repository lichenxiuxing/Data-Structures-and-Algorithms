/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/6
 * 9:33
 * 未完成：用链表实现栈
 */
public class ListStack {
    public static void main(String[] args) {

    }
}

class ListStackDemo {
    private Node head=new Node(-1);
    private int maxsize;
    private Node top=head;

    //判断是否为空
    public boolean isEmpty() {
        return top.num==head.num;
    }

    //判断是否已满
    public boolean isFull() {
        return top.num == maxsize - 1;
    }

    //push方法
    public void push(int i) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top=top.next;
        top.data = i;
    }
    //pop方法
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int i=top.data;
        //未完成
        return i;
    }
}

class Node {
    public int num;
    public int data;
    public Node next;

    public Node(int num) {
        this.num = num;
    }
}
