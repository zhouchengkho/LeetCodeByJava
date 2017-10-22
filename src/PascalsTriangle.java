import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/22/17.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new LinkedList<>();
        if(numRows <= 0) return ls;
        List<Integer> t = new LinkedList<>();
        t.add(1);
        ls.add(new LinkedList<>(t));
        for(int i = 1; i < numRows; i++) {
            List<Integer> temp = new LinkedList<>();
            int len = ls.get(i-1).size();
            for(int j = 0; j < i+1; j++) {
                int a = (j <= len - 1 && j >= 0) ? ls.get(i-1).get(j) : 0;
                int b = (j-1 <= len - 1 && j-1 >= 0) ? ls.get(i-1).get(j-1) : 0;
                temp.add(a+b);
            }
            ls.add(new LinkedList(temp));
        }
        return ls;
    }
}
