/**
 * Created by zhoucheng on 12/24/17.
 */
public class Greedy {
    public boolean canPlaceFlowers(int[] f, int n) {
        int count = 0;
        for(int i = 0; i < f.length; i++) {
            if(f[i] == 1) {
                if(i - 1 >= 0) f[i - 1] = 2;
                if(i + 1 <= f.length - 1) f[i + 1] = 2;
            }
        }

        for(int i = 0; i < f.length; i++) {
            if(f[i] == 0) {
                count++;
                if(count >= n) return true;
                f[i] = 1;
                if(i + 1 <= f.length - 1) f[i + 1] = 2;
            }
        }

        System.out.println(mutate("0", 0, true));
        return count >= n;
    }

    private String mutate(String s, int i, boolean up) {
        if(up) {
            if(s.charAt(i) == '9') return s.substring(0, i) + "0" + s.substring(i+1);

            return s.substring(0, i) + String.valueOf((char)(s.charAt(i) + 1)) + s.substring(i+1);
        } else {
            if(s.charAt(i) == '0') return s.substring(0, i) + "9" + s.substring(i+1);
            return s.substring(0, i) + String.valueOf((char)(s.charAt(i) - 1)) + s.substring(i+1);
        }
    }

    public static void main(String[] args) {
        Greedy sol = new Greedy();
        int[] f = new int[3];
        sol.canPlaceFlowers(f, 3);
    }
}
