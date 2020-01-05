import java.util.SortedMap;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/5
 * 20:01
 */
public class TestPrivatePublic {
    public static void main(String[] args) {
        Hero h1=new Hero(14,"lisi");
        Hero h2=h1;
        h2.setAge(13);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h1==h2);
    }
}
class Hero{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Hero(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
