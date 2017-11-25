import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhoucheng on 11/11/17.
 */
public class LongestPhrasesInATweet {
    int maxLength(int[] a, int k) {
        Queue<Integer> q = new LinkedList<>();
        track(q, a, 0, k, 0);
        return max;
    }
    int max = 0;

    private void track(Queue<Integer> q, int[] a, int now, int k, int pos) {
        if(now > k) return;
        max = Math.max(max, q.size());
        for(int i = pos; i < a.length; i++) {
            q.offer(a[i]);
            track(q, a, now+a[i], k, i+1);
            q.poll();
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,3};
        int k = 6;
        LongestPhrasesInATweet sol = new LongestPhrasesInATweet();
        System.out.println(sol.maxLength(a, k));
    }
}
