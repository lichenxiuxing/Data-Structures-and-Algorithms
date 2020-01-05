/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/5
 * 16:30
 * 双向链表的实现
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 heroNode4 = new HeroNode2(4, "武松", "行者");
        DoubleLinkedLiseDemo doubleLinkedLiseDemo = new DoubleLinkedLiseDemo();
        /*//测试单链表无序添加
        doubleLinkedLiseDemo.add(heroNode1);
        doubleLinkedLiseDemo.add(heroNode2);
        doubleLinkedLiseDemo.add(heroNode3);
        doubleLinkedLiseDemo.add(heroNode4);
        doubleLinkedLiseDemo.list();
        HeroNode2 heroNode5=new HeroNode2(1,"孙胜","入云龙");
        doubleLinkedLiseDemo.update(heroNode5);
        System.out.println("修改后的结果");
        doubleLinkedLiseDemo.list();
        doubleLinkedLiseDemo.delete(4);
        System.out.println("删除后的结果");
        doubleLinkedLiseDemo.list();*/
        //测试有序添加

        doubleLinkedLiseDemo.addByOrder(heroNode2);
        doubleLinkedLiseDemo.addByOrder(heroNode1);
        doubleLinkedLiseDemo.addByOrder(heroNode3);
        doubleLinkedLiseDemo.addByOrder(heroNode4);
        doubleLinkedLiseDemo.list();
    }
}
//单链表
class DoubleLinkedLiseDemo {
    private HeroNode2 head = new HeroNode2(0, "", "");//创建头结点

    public HeroNode2 getHead() {
        return head;
    }

    //链表添加方法(添加到最后）
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;//创建临时节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre=temp;
    }

    //链表修改
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.printf("此编号%d不存在\n", n);
                break;
            }
            if (temp.n == n) {
                temp.pre.next = temp.next;
                if(temp.next!=null){
                    temp.next.pre=temp.pre;
                }
                System.out.printf("编号%d已删除\n", n);
                break;
            }
            temp = temp.next;
        }
    }
    //链表按顺序添加
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                heroNode.next = temp.next;
                temp.next=heroNode;
                heroNode.pre=temp;
                break;
            }
            if (temp.next.n > heroNode.n) {
                heroNode.next = temp.next;
                temp.next.pre=heroNode;
                temp.next = heroNode;
                heroNode.pre=temp;
                break;
            } else if (temp.next.n == heroNode.n) {
                System.out.printf("此编号%d已存在\n", heroNode.n);
                break;
            }
            temp = temp.next;
        }
    }

    //链表遍历方法
    public void list() {
        HeroNode2 temp = head.next;//创建临时节点
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
class HeroNode2 {
    public int n;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int n, String name, String nickName) {
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
