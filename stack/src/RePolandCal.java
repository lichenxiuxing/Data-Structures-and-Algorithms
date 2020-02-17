import javax.sound.midi.Soundbank;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/6
 * 16:08
 * 后缀表达式
 * 即逆波兰计算器
 */
public class RePolandCal {
    public static void main(String[] args) {
        String as = "3+5-3*20";
        List<String> list = midToList(as);
        System.out.println("转换为列表为：" + list);
        List<String> list1 = tran(list);
        System.out.println("转换的后缀表达式为：" + list1);
        int res=reversePoland(list1);
        System.out.println("计算结果为："+res);

    }

    //判断符号优先级的方法
    public static int judge(String ch) {
        if (ch.equals("*")  || ch.equals("/")) {
            return 1;
        } else {
            return 0;
        }
    }

    //中缀转后缀
    public static List<String> tran(List<String> list) {
        Stack<String> stack1 = new Stack();
        ArrayList<String> stack2 = new ArrayList();
        for (String s : list) {
            //如果是数字，直接压入stack2
            if (s.matches("\\d+")) {
                stack2.add(s);
            }//为（或者stack1为空时，直接压入stack1
            else if (s.equals("(")) {
                stack1.push(s);
            }//为)时需要进行弹出操作，直到没有(为止，且要将(弹出
            else if (s.equals(")")) {
                while (stack1.peek() != "(") {
                    stack2.add(stack1.pop());
                }
                stack1.pop();
            } else {
                //判断优先级
                while ((stack1.size() != 0) && judge(stack1.peek())>=judge(s)) {
                    stack2.add(stack1.pop());
                }
                stack1.push(s);
            }
        }
        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }
        return stack2;
    }

    //中缀转为list
    public static List<String> midToList(String s) {
        List<String> arrayList = new ArrayList<>();
        String temp;
        int i = 0;
        do {
            if ((s.charAt(i)) < 48 || (s.charAt(i) > 57)) {
                //如果不是数字，直接放入
                arrayList.add(s.charAt(i) + "");
                i++;
            }//数字时，考虑多位数的情况
            else {
                temp = "";
                //要将判断条件加在前面才不会出现越栈异常
                while ((i < s.length()) && (48 <= s.charAt(i)) && (s.charAt(i) <= 57)) {
                    //while(i < s.length() && (s.charAt(i)) >= 48 && (s.charAt(i)) <= 57) {
                    String s1 = s.charAt(i) + "";
                    temp += s1;
                    i++;
                }
                arrayList.add(temp);
            }
        } while (i < s.length());
        return arrayList;
    }

    //逆波兰计算器的实现
    public static int reversePoland(List<String> ls) {
        Stack<String> stack = new Stack();
        for (String l : ls) {
            if (l.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(l);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (l.equals("+")) {
                    res = num1 + num2;
                    stack.push(res + "");
                } else if (l.equals("-")) {
                    res = num1 - num2;
                    stack.push(res + "");
                } else if (l.equals("*")) {
                    res = num1 * num2;
                    stack.push(res + "");
                } else if (l.equals("/")) {
                    res = num1 / num2;
                    stack.push(res + "");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //将字符串进行分割
    public static String[] convert(String s) {
        String[] strings = s.split(" ");
        return strings;
    }
}
