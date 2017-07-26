import com.sun.tools.javac.jvm.Gen;

import java.util.*;

/**
 * Created by zhoucheng on 7/23/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }
}
