import java.util.Arrays;

/**
 * Created by zhoucheng on 10/26/17.
 */
public class BiggestSubsequence {
    public String findIt(String s) {
        if(s.length() == 0) return "";
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) > c) {
                c = s.charAt(i);
            }
        }
        // found c
        String sub = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c && isBigger(s.substring(i), sub)) {
                sub = s.substring(i);
            }
        }
        return sub;
    }

    public boolean isBigger(String a, String b) {
        if (a.length() > b.length()) return isBigger(b, a);
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) > b.charAt(i)) return true;
        }
        return false;
    }
}
