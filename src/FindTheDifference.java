/**
 * Created by zhoucheng on 11/25/17.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        /**
         t should have exactly one more letter
         */
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum+=(t.charAt(i) - s.charAt(i));
        }
        sum+=t.charAt(s.length());

        return (char)sum;
    }
}
