public class SqrtX {
    public int mySqrt(int x) {
        if(x <= 0) return x;
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    public static void main(String[] args) {
        SqrtX solution = new SqrtX();
        int x = 2147395599;
        System.out.println(solution.mySqrt(x));

        System.out.println(-3/2);
    }
}
