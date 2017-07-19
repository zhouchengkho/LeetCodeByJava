import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 7/12/17.
 */
public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.contains("0") || digits.contains("1")) {
            return ans;
        }
        ans.add("");
        for(int i = 0;i<digits.length();i++) {
            int next = digits.charAt(i) - 48;
            while(ans.peek().length() == i) {
                String str = ans.remove();
                for(char c : mapping[next].toCharArray()) {
                    System.out.println(str+c);
                    ans.add(str+c);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        LetterCombinationOfAPhoneNumber solution = new LetterCombinationOfAPhoneNumber();
        String digits = "";
        System.out.println(solution.letterCombinations(digits));
    }
}
