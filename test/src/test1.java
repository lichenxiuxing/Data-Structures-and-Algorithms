import java.util.ArrayList;
import java.util.SortedMap;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/7
 * 22:15
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i <39 ; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
