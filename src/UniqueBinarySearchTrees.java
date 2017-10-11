import java.util.Arrays;

/**
 * Created by zhoucheng on 10/10/17.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] way = new int[n+1];
        if(n <= 1) {
            return 1;
        }
        Arrays.fill(way, 0);
        way[0] = 1;
        way[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                way[i] += way[j]*way[i-j-1];
            }
        }
        return way[n];
    }

    private void print(int[] way) {
        for(int i = 0; i < way.length; i++) {
            System.out.print(way[i] + " ");
        }
        System.out.println();
    }
}
