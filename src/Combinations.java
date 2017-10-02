import java.util.ArrayList;
import java.util.List;


public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        track(n+1, k , 1, ls, new ArrayList<>());
        return ls;
    }

    private void track(int n, int k, int c, List<List<Integer>> ls, List<Integer> tempList) {
        if(tempList.size() == k) {
            ls.add(new ArrayList<>(tempList));
        } else {
            for(int i = c; i < n; i++) {
                tempList.add(i);
                track(n, k, i+1, ls, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
