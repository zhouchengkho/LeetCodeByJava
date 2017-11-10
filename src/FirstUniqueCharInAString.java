import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoucheng on 11/5/17.
 */
public class FirstUniqueCharInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();
        // int index = -1;
        List<Character> ls = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(m.containsKey(c)) {
                int count = m.get(c);
                m.replace(c, count+1);
                if(count == 1) ls.remove(ls.indexOf(c));
            } else {
                m.put(c, 1);
                ls.add(c);
            }
        }
        if(ls.size() == 0) return -1;
        Character ch = ls.get(0);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) return i;
        }
        return -1;
    }
}
