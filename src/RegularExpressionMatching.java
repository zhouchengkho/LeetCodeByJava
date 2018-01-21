import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 1/20/18.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() != 0) return false;
        /**
         pattern
         . single any char
         c*, 0-n some character
         c, single some chacter


         int[2]
         index 0: some character
         index 1: single, any, 0-n
         0  ,  1 ,  2
         special case: if comes thru .*, it matches everything after
         */

        List<int[]> ls = new LinkedList<>();
        for(int i = 0; i < p.length(); i++) {
            if(i < p.length() - 1 && p.charAt(i + 1) == '*') {
                ls.add(new int[]{(int)p.charAt(i), 2});
            } else if(p.charAt(i) == '.') {
                ls.add(new int[]{(int)p.charAt(i), 1});
            } else {
                // normal char
                ls.add(new int[]{(int)p.charAt(i), 0});
            }
        }

        boolean[][] dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                dp[i][j] = dp[i-1][j-1] && match(s.charAt(i - 1), ls.get(j - 1));
            }
        }



        return dp[s.length()][p.length()];
    }

    private boolean match(char c, int[] p) {
        if((char)p[0] == '.') return true;
        if((char)p[0] == c) return true;
        return false;
    }
}
