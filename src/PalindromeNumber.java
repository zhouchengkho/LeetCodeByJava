/**
 * Created by zhoucheng on 5/11/17.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String num = "" + Math.abs(x);
        int len = num.length();
        for(int i = 0; i < len; i++) {
            if(num.charAt(i) != num.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // write your code here
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(222));
    }
}
