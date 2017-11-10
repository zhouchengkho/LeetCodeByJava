/**
 * Created by zhoucheng on 10/27/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = preHandle(s);
        int len = s.length();
        for(int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    public String preHandle(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if( (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9') ) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
