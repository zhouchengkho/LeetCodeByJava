import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhoucheng on 4/30/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            ArrayList temp = new ArrayList();
            for(int j = i; j < s.length(); j++) {
                if(temp.contains(s.charAt(j))) {
                    max = temp.size() > max ? temp.size() : max;
                    break;
                } else {
                    temp.add(s.charAt(j));
                    max = temp.size() > max ? temp.size() : max;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // write your code here
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("c"));

    }
}


