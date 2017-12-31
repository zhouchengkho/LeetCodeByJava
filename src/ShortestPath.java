import java.util.*;

/**
 * Created by zhoucheng on 12/26/17.
 */
public class ShortestPath {
    public int networkDelayTime(int[][] times, int N, int K) {

        String[] words = {};
        List<String> ls = Arrays.asList(words);
        ls.sort((x, y) -> (x.length() <= y.length() ? 1 : -1));


        // u, v, w
        TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        initMap(times, map, K);
        dij(map, tree, K, N);
        return tree.size() == N ? maxInTree(tree) : -1;
    }

    private void initMap(int[][] times, TreeMap<Integer, TreeMap<Integer, Integer>> map, int s) {
        for(int i = 0; i < times.length; i++) {
            int[] time = times[i];
            if(map.containsKey(time[0])) {
                map.get(time[0]).put(time[1], time[2]);
            } else {
                map.put(time[0], new TreeMap<>());
                map.get(time[0]).put(time[1], time[2]);
            }
        }

        if(map.containsKey(s)) {
            map.get(s).put(s, 0);
        } else {
            map.put(s, new TreeMap<>());
            map.get(s).put(s, 0);
        }
    }

    private class vec {
        int i;
        int d;
        vec(int id, int weight) {
            i = id;
            d = weight;
        }
    }
    private void dij(TreeMap<Integer, TreeMap<Integer, Integer>> map, TreeMap<Integer, Integer> tree, int s, int n) {
        int max = 0;
        PriorityQueue<vec> q = new PriorityQueue<>(n, (x, y) -> Integer.compare(x.d, y.d));

        q.add(new vec(s, 0));
        tree.put(s, 0);

        while(!q.isEmpty()) {
            vec u = q.remove();
            if(map.containsKey(u.i)) {
                for(Map.Entry<Integer, Integer> e : map.get(u.i).entrySet()) {
                    int v = e.getKey();
                    int vw = e.getValue();
                    if(tree.containsKey(v) && tree.get(v) <= u.d + vw) continue;
                    tree.put(v, u.d + vw);
                    q.add(new vec(v, u.d + vw));
                }
            }
        }
    }
    private int maxInTree(TreeMap<Integer, Integer> tree) {
        int max = 0;
        for(Map.Entry<Integer, Integer> e : tree.entrySet()) {
            max = Math.max(e.getValue(), max);
        }
        return max;
    }
}
