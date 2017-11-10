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

    public int climbThree(int n) {
        if(n <= 0) return 0;
        if(n <= 1) return 1;
        if(n <= 2) return 2;
        if(n <= 3) return 4;

        int one_step_before = 4;
        int two_steps_before = 2;
        int three_steps_before = 1;
        int all_ways = 0;
        for(int i = 3; i < n; i++) {
            all_ways = one_step_before + two_steps_before + three_steps_before;
            three_steps_before = two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    public static void main(String args) {

    }
}
