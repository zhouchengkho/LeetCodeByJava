/**
 * Created by zhoucheng on 12/3/17.
 */
public class DP {
    public int minimumDeleteSum(String s1, String s2) {

        int s[][] = new int[s1.length()+1][s2.length()+1];


        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j == 0) {
                    s[i][j] = 0;
                    continue;
                } else if(i == 0) {
                    s[i][j] = s[i][j-1] + s2.charAt(j-1);
                    continue;
                } else if(j == 0) {
                    s[i][j] = s[i-1][j] + s1.charAt(i-1);
                    continue;
                }

                s[i][j] = s[i-1][j-1];
                if(s1.charAt(i-1) != s2.charAt(j-1)) {
                    s[i][j] = s[i-1][j-1] + (s1.charAt(i-1) + s2.charAt(j-1));
                }
                if(s[i-1][j] + s1.charAt(i-1) < s[i][j]) s[i][j] = s[i-1][j] + s1.charAt(i-1);
                if(s[i][j-1] + s2.charAt(j-1) < s[i][j]) s[i][j] = s[i][j-1] + s2.charAt(j-1);

            }
        }

        return s[s1.length()][s2.length()];

    }
}
