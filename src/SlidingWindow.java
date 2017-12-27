import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 11/28/17.
 */
public class SlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new LinkedList<>();
        // sliding window

        int[] hash = new int[256];
        Arrays.fill(hash, 0);

        for(int i = 0; i < p.length(); i++) {
            hash[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();
        while(right < s.length()) {
            if(hash[s.charAt(right)] >= 1) {
                // hit
                count--;
            }
            hash[s.charAt(right)]--;
            right++;


            if(count == 0) {
                ls.add(left);
            }

            if(right - left == p.length()) {
                // window full
                if(hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }

        }

        return ls;

    }

}
