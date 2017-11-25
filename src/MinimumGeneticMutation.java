import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhoucheng on 11/11/17.
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {

        // use set to improve performance
        Set<String> set = new HashSet<>();
        for(int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        track(start, end, set, 0);
        return min;
    }

    int min = -1;
    char[] mutations = {'A', 'C', 'G', 'T'};

    public void track(String start, String end, Set<String> set, int count) {
        if (min > 0 && count > min) return;
        if (end.equals(start)) {
            min = count;
            return;
        }
        for(int i = 0; i < start.length(); i++) {
            for(int j = 0; j < mutations.length; j++) {
                if (start.charAt(i) == mutations[j]) continue;
                String mu = mutate(start, i, mutations[j]);
                if(set.contains(mu)) {
                    set.remove(mu);
                    track(mu, end, set, count+1);
                }
            }
        }
    }

    public String mutate(String s, int pos, char c) {
        return s.substring(0, pos) + String.valueOf(c) + s.substring(pos+1, s.length());
    }
}
