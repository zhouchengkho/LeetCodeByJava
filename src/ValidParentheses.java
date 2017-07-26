import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by zhoucheng on 7/19/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> ans = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('}', '{');
        map.put('(', ')');
        map.put(')', '(');
        map.put('[', ']');
        map.put(']', '[');
        for(int i = 0;i<s.length();i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch) && ans.size() > 0 && map.get(ch).equals(ans.getLast())) {
                ans.removeLast();
            }
            else {
                ans.add(ch);
            }
        }
        return ans.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String str = "{{{()}}}";
        System.out.println(solution.isValid(str));
    }
}
