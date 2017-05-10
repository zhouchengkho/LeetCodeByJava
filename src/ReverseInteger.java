/**
 * Created by zhoucheng on 5/10/17.
 */
public class ReverseInteger {
    public int reverse(int x) {
        String result = "";
        String num = "" + Math.abs(x);
        int len = num.length();
        for(int i = 0; i < len; i++) {
            result = result.concat(String.valueOf(num.charAt(len - 1 - i)));
        }
        try {
            int val = x < 0 ? -1 * Integer.parseInt(result) : Integer.parseInt(result);
            return val;
        } catch(Exception e) {
            return 0;
        }
    }
    public static void main(String[] args) {
        // write your code here
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(1534236469));

    }
}
