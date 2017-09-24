/**
 * Created by zhoucheng on 9/20/17.
 */
public class PowXN {
    public double myPow(double x, int n) {
        int MIN = -2147483648;
        int MAX = 2147483647;
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1/x;
            n = -n;
            if(n == MIN) {
                n = MAX;
                x = x*x;
            }
        }
        return (n%2 == 0) ? myPow(x * x, n / 2) : x * myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        double x = 2;
        int n = -2147483648;
        System.out.println(solution.myPow(x, n));
    }
}
