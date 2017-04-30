import java.util.ArrayList;

/**
 * Created by zhoucheng on 4/30/17.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int pos = 2 * s.length();
        int max = 1;
        String result = s.substring(0, 1);
        for(int i = 0; i < pos; i++) {
            String temp = findPalindrome(i, s);
            if(temp.length() > max) {
                max = temp.length();
                result = temp;
            }
        }
        return result;
    }



    public String findPalindrome(int pivot, String s) {
        int offset = 0;
        int len = s.length();
        while(true) {
            int leftIndex = (pivot - 1) / 2 - offset;
            int rightIndex = (pivot) / 2 + offset;
            if(leftIndex < 0 || rightIndex >= len)
                break;
            else if(s.charAt(leftIndex) != s.charAt(rightIndex)) {
                break;
            }
            else offset++;
        }
        int left = (pivot - 1) / 2 - offset + 1 < 0 ? 0 : (pivot - 1) / 2 - offset + 1;
        int right = (pivot + offset) / 2 >= len ? len - 1 : (pivot) / 2 + offset;
        return s.substring(left, right);
    }

    public static void main(String[] args) {
        // write your code here
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
         System.out.println(solution.longestPalindrome("dasadffffffff"));

    }
}
