/**
 * Created by zhoucheng on 9/29/17.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // performance better than recursion
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    private int way(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return way(n-1)+way(n-2);
    }
    private int comb(int m, int n) {
        m++;
        n++;
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    public static void main(String args) {

    }
}
