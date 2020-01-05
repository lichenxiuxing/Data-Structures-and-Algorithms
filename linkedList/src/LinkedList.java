import java.rmi.Naming;
import java.security.PublicKey;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/3
 * 20:27
 */
public class LinkedList {
    public static void main(String[] args) {
        //测试单链表
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "武松", "行者");
        LinkedLiseDemo linkedLiseDemo = new LinkedLiseDemo();
        //测试单链表无序添加
        /*linkedLiseDemo.add(heroNode1);
        linkedLiseDemo.add(heroNode2);
        linkedLiseDemo.add(heroNode3);
        linkedLiseDemo.add(heroNode4);
        linkedLiseDemo.list();*/
        //测试单链表有序添加
        linkedLiseDemo.addByOrder(heroNode1);
        linkedLiseDemo.addByOrder(heroNode4);
        linkedLiseDemo.addByOrder(heroNode3);
        linkedLiseDemo.addByOrder(heroNode2);
        linkedLiseDemo.list();
        /*//测试根据编号来更新
        System.out.println("修改后的链表为");
        heroNode2.name = "小卢";
        heroNode2.nickName = "玉麒麟花花";
        linkedLiseDemo.update(heroNode2);
        linkedLiseDemo.list();*/
        /*//测试删除
        linkedLiseDemo.delete(1);
        linkedLiseDemo.list();
        linkedLiseDemo.delete(4);
        linkedLiseDemo.list();
        linkedLiseDemo.delete(2);
        linkedLiseDemo.list();
        linkedLiseDemo.delete(3);
        linkedLiseDemo.list();
        linkedLiseDemo.delete(1);*/
        /*//测试查找
        linkedLiseDemo.find(1);
        linkedLiseDemo.find(4);*/
        /*//测试链表长度
        linkedLiseDemo.delete(1);
        System.out.printf("链表长度为%d\n",findNum(linkedLiseDemo.getHead()));*/
        //测试链表中倒数第k个节点
        //System.out.printf("倒数第%d个节点为\n" + findK(linkedLiseDemo.getHead(), 8), 8);
        //测试链表反转
//        reverse(linkedLiseDemo.getHead());
//        System.out.println("反转后的链表为");
//        linkedLiseDemo.list();
        //测试链表反转打印（不破坏原有链表结构）
        System.out.println("反转后的结果为");
        printReverse(linkedLiseDemo.getHead());

    }

    //有效节点个数，根据所查询链表的头结点
    public static int findNum(HeroNode head) {
        HeroNode temp = head.next;
        int i = 0;
        while (true) {
            if (temp == null) {
                break;
            } else {
                i++;
            }
            temp = temp.next;
        }
        return i;
    }

    //查询单链表中倒数第k个节点
    public static HeroNode findK(HeroNode head, int k) {
        HeroNode temp = head.next;
        int size = findNum(head);
        if (k <= 0 || k > size) {
            temp = null;
        }
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //反转链表的实现
    public static void reverse(HeroNode head) {
        HeroNode reverseHead = new HeroNode(-1, "", "");
        HeroNode temp = head.next;//临时节点
        HeroNode next = null;//为防止节点丢失，提前保留下一个节点
        if (temp == null || temp.next == null) {
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            } else {
                next = temp.next;
                temp.next = reverseHead.next;
                reverseHead.next = temp;
                temp = next;
            }
        }
        head.next = reverseHead.next;
        return;
    }

    //反转打印链表
    public static void printReverse(HeroNode head) {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
        return;
    }

}

//单链表
class LinkedLiseDemo {
    private HeroNode head = new HeroNode(0, "", "");//创建头结点

    public HeroNode getHead() {
        return head;
    }

    //链表添加方法
    public void add(HeroNode heroNode) {
        HeroNode temp = head;//创建临时节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.next = null;
    }

    //链表按顺序添加
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            if (temp.next.n > heroNode.n) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            } else if (temp.next.n == heroNode.n) {
                System.out.printf("此编号%d已存在\n", heroNode.n);
                break;
            }
            temp = temp.next;
        }
    }

    //链表修改
    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.printf("要修改的%d不存在\n", heroNode.n);
                break;
            }
            if (temp.n == heroNode.n) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    //链表删除
    public void delete(int n) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.printf("此编号%d不存在\n", n);
                break;
            }
            if (temp.next.n == n) {
                temp.next = temp.next.next;
                System.out.printf("编号%d已删除\n", n);
                break;
            }
            temp = temp.next;
        }
    }

    //链表查找
    public void find(int n) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.printf("此编号%d不存在\n", n);
                break;
            }
            if (temp.n == n) {
                System.out.printf("此用户为" + temp.toString() + "\n");
                break;
            }
            temp = temp.next;
        }
    }

    //链表遍历方法
    public void list() {
        HeroNode temp = head.next;//创建临时节点
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//结点类
class HeroNode {
    public int n;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int n, String name, String nickName) {
        this.n = n;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "n=" + n +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
