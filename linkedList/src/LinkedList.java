import java.rmi.Naming;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/3
 * 20:27
 */
public class LinkedList {
    public static void main(String[] args) {
        //测试单链表
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"林冲","豹子头");
        HeroNode heroNode4=new HeroNode(4,"武松","行者");
        LinkedLiseDemo linkedLiseDemo=new LinkedLiseDemo();
        linkedLiseDemo.add(heroNode1);
        linkedLiseDemo.add(heroNode2);
        linkedLiseDemo.add(heroNode3);
        linkedLiseDemo.add(heroNode4);
        linkedLiseDemo.list();
    }
    //单链表
    public static class LinkedLiseDemo{
        private HeroNode head=new HeroNode(0,"","");//创建头结点
        //链表添加方法
        public void add(HeroNode heroNode){
            HeroNode temp=head;//创建临时节点
            while (true){
                if(temp.next==null){
                    break;
                }
                temp=temp.next;
            }
            temp.next=heroNode;
            heroNode.next=null;
        }
        //链表遍历方法
        public void list(){
            HeroNode temp=head.next;//创建临时节点
            while (true){
                if(temp==null){
                    break;
                }
                System.out.println(temp);
                temp=temp.next;
            }
        }
    }
    //结点类
    static class HeroNode{
        public int n;
        public String name;
        public String nickName;
        public HeroNode next;
        public HeroNode(int n,String name,String nickName){
            this.n=n;
            this.name=name;
            this.nickName=nickName;
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

}
