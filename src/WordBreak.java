import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhoucheng on 11/6/17.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        Set<String> record = new HashSet<>();

        return track(s, set, record);

    }
    public boolean track(String s, Set<String> set, Set<String> record) {
        if(record.contains(s)) return false;
        if(set.contains(s)) {
            return true;
        } else {
            for(int i = 1; i < s.length(); i++) {
                if(set.contains(s.substring(0, i))) {
                    String pc = s.substring(i, s.length());
                    System.out.println(pc);
                    if(track(pc, set, record)) {
                        return true;
                    } else {
                        record.add(pc);
                    }
                }
            }
        }
        return false;
    }
}
