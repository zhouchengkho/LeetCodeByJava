import java.util.*;

/**
 * Created by zhoucheng on 11/6/17.
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean f[] = new boolean[s.length()+1];
        Arrays.fill(f, false);

        f[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];

    }

    // DP
    public List<String> wordBreakTwo(String s, List<String> wordDict) {
        int maxWord = 0;
        int lastOk = 0;
        for(int i = 0; i < wordDict.size(); i++) {
            maxWord = Math.max(maxWord, wordDict.get(i).length());
        }
        List<List<String>> ls = new LinkedList<>();
        boolean f[] = new boolean[s.length()+1];
        for(int i = 0; i <= s.length(); i++) {
            ls.add(new LinkedList<>());
            f[i] = false;
        }
        ls.get(0).add("");
        f[0] = true;


        for(int i = 1; i <= s.length(); i++) {
            if(i - lastOk > maxWord) break;
            for(int j = 0; j < i; j++) {
                if(f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    lastOk = i;
                    for(int k = 0; k < ls.get(j).size(); k++) {
                        String t = ls.get(j).get(k) + " "+ s.substring(j, i);
                        ls.get(i).add(t.trim());
                    }
                }
            }
        }

        return ls.get(s.length());
    }

    // DFS
    public List<String> wordBreakDFS(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }

        List<String> ls = new LinkedList<>();

        if(s.length() == 0) {
            ls.add("");
            return ls;
        }

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> partList = new LinkedList<>();
                partList = dfs(s.substring(word.length()), wordDict, map);
                for(String part : partList){
                    ls.add(word+ (part.isEmpty() ? "" : " ")+part);
                }
            }
        }

        map.put(s, ls);
        return ls;
    }

}
