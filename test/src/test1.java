import com.sun.jmx.mbeanserver.NamedObject;
import com.sun.media.sound.SoftTuning;
import org.omg.PortableInterceptor.INACTIVE;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.StreamSupport;

/**
 * @Copyright LiChen
 * 用户：biyang
 * 创建时间：2020/1/7
 * 22:15
 */
public class test1 {
    public static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {

    }
    public static String minWindow(String s, String t) {
        if (s == null || t== null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";
        int[] need = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int min = t.length() + 1;
        int start = 0;
        int count = 0;
        while (right < s.length()) {
            char temp = s.charAt(right);
            if (need[temp] == 0) {
                right++;
                continue;
            }
            if (window[temp] < need[temp]) {
                count++;
            }
            window[temp]++;
            right++;
            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                if (need[l] == window[l]) {
                    count--;
                }
                window[l]--;
                left++;
            }
        }
        if (min == t.length() + 1) return "";
        return s.substring(start, start + min);
    }
    public static int fib2(int n) {
        int a = 1;
        int b = 1;
        int c = a + b;
        if (n <= 2) return a;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static int fib1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static int fib(Map<Integer, Integer> map, int n) {
        if (n == 1 || n == 2) return 1;
        if (map.containsKey(n)) return map.get(n);
        map.put(n, fib(map, n - 1) + fib(map, n - 2));
        return map.get(n);
    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email : emails) {
            String[] strings = email.split("@");
            String local = strings[0];
            String rest = strings[1];
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }
        return seen.size();
    }
    public static String reverseWords(String s) {
        String[] temp = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = temp.length - 1; i >= 0; i--){
            if (!temp[i].equals("")){
                sb.append(temp[i].trim() + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static List<Integer> midList(Node root) {
        recur(root);
        return list;
    }
    public static void recur(Node root) {
        if (root == null) return;
        recur(root.left);
        list.add(root.val);
        recur(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val){
        this.val = val;
    }
}


