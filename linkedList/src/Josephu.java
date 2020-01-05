import java.beans.BeanInfo;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/5
 * 19:21
 * 约瑟夫出圈问题
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.list();
        System.out.println("出圈的顺序为");
        circleSingleLinkedList.out(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    public Boy first;

    //添加Boy方法
    public void add(int m) {
        Boy temp = null;
        for (int i = 1; i <= m; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                temp = first;
            }
            temp.setNext(boy);
            boy.setNext(first);
            temp = boy;
        }
    }

    //遍历方法
    public void list() {
        Boy temp = first;
        while (temp.getNext() != first) {
            System.out.printf("当前编号为%d\n", temp.getN());
            temp = temp.getNext();
        }
        System.out.printf("当前编号为%d\n", temp.getN());
    }

    //出圈
    public void out(int begin, int step, int nums) {
        if (begin < 1 || begin > nums || first == null) {
            System.out.println("输入错误，请重新开始");
            return;
        }
        Boy temp = first; //辅助节点，在first之前
        while (temp.getNext() != first) {
            temp = temp.getNext();
        }
        /*System.out.println(temp.getN());
        System.out.println(temp.getNext().getN());
        System.out.println(first.getN());
        System.out.println(first.getNext().getN());*/
        for (int i = 0; i < begin - 1; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }
        while (temp != first) {
            for (int i = 0; i < step - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.printf("当前编号为%d\n", first.getN());
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.printf("当前编号为%d\n", first.getN());
    }
}

class Boy {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    private Boy next;

    //构造函数
    public Boy(int n) {
        this.n = n;
    }
}
