import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/26/17.
 */
public class JosephProblem {
    public int findPos(int n, int k) {
        List<Integer> ls = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            ls.add(i);
        }
        int p = -1;
        while(ls.size() > 1) {
            for(int i = 0; i < k; i++) {
                p++;
            }
            if(p >= ls.size()) {
                p = p%ls.size();
            }
            ls.remove(p);
        }
        return ls.get(0);
    }
}
