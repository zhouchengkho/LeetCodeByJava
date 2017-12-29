import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoucheng on 12/28/17.
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue; // self
                int dist = computeDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for(int val : map.values()) {
                res+=(val * (val - 1));
            }

            map.clear();
        }

        return res;
    }

    private int computeDistance(int[] x, int [] y) {
        return (int)Math.pow(Math.abs(x[0]-y[0]), 2) + (int)Math.pow(Math.abs(x[1] - y[1]), 2);
    }
}

