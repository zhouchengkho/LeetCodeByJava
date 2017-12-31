import java.util.Arrays;

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

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        if(points.length == 1) return 1;
        Arrays.sort(points, (x, y) -> (x[1] - y[1]));
        // int min = points[0][0];
        int max = points[0][1];
        int count = 0;
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= max) {
                // overlaps, can be shot together
                // since sorted by max, no need to change it
            } else {
                // fire this shot
                count++;
                // aim for the next overlapping
                // min = points[i][0];
                max = points[i][1];
            }
        }
        return count + 1;
    }
    public static void main(String[] args) {
        Greedy sol = new Greedy();
        int[] f = new int[3];
        sol.canPlaceFlowers(f, 3);
    }
}
