/**
 * Created by zhoucheng on 8/2/17.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        final int INT_MAX = 2147483647;
        final int INT_MIN = -2147483648;
        int flag = dividend * divisor > 0 ? 1 : -1;
        if(divisor == 0 || (dividend == INT_MIN && divisor == -1)) {
            return INT_MAX;
        }
        long end = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);
        long result = ldivide(end, sor);

        return (int)result * flag;
    }

    public long ldivide(long ldividend, long ldivisor) {
        if(ldivisor > ldividend) {
            return 0;
        }
        long sum = ldivisor;
        long multiple = 1;
        while(sum+sum < ldividend) {
            sum+=sum;
            multiple+=multiple;
        }

        return multiple + ldivide(ldividend-sum, ldivisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int dividend = -2147483648;
        int divisor = -2;
        System.out.println(solution.divide(dividend, divisor));
    }
}
