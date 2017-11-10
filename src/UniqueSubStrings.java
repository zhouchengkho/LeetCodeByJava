import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhoucheng on 11/3/17.
 */
public class UniqueSubStrings {
    public String[] find(String s, int k) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < len - k + 1; i++) {
            String sub = s.substring(i, i+k);
            System.out.println(sub);
            if(!set.contains(sub)) {
                set.add(sub);
            }
        }
        String[] r = new String[set.size()];
        int i = 0;
        for(String sub : set) {
            r[i] = sub;
            i++;
        }
        return r;
    }

    public static void main(String[] args) {
        UniqueSubStrings solution = new UniqueSubStrings();
        String[] s = solution.find("caaab", 6);
        System.out.println("result:");
        for(int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }
}
