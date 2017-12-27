import java.util.*;

/**
 * Created by zhoucheng on 10/27/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        HashSet<String> wl = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            wl.add(wordList.get(i));
        }
        beginSet.add(beginWord);
        while (!beginSet.isEmpty()) {
            // for(String str : beginSet) {
            //     System.out.print(str+" ");
            // }
            System.out.println();
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endWord.equals(target) && wl.contains(target) && !visited.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wl.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String s : wordList) dict.add(s);
        List<List<String>> result = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> neighbor = new HashMap<>();
        bfs(beginWord, endWord, distance, neighbor, dict);
        dfs(beginWord, endWord, new LinkedList<>(), result, neighbor, distance);
        return result;
    }

    private void bfs(String source, String end, Map<String, Integer> distance, Map<String, List<String>> neighbor, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        q.offer(source);
        distance.put(source, 0);

        // for(String s : dict) neighbor.put(s, new LinkedList<>());
        boolean found = false;
        while(!q.isEmpty()) {
            int thisStepCount = q.size();
            while(thisStepCount > 0) {
                thisStepCount--;
                String u = q.poll();
                List<String> n = getNeighbor(u, neighbor, dict);
                for(String v : n) {
                    if(v.equals(end)) found = true;
                    if(!distance.containsKey(v)) {
                        // first time visiting
                        distance.put(v, distance.get(u) + 1);
                        q.offer(v);
                    }
                }
            }
            if(found) break; // SP to end has found, no need to loop anymore
        }

    }

    private void dfs(String cur, String end, List<String> sol, List<List<String>> res, Map<String, List<String>> neighbor, Map<String, Integer> distance) {
        sol.add(cur);
        if(cur.equals(end)) res.add(new LinkedList<>(sol));
        else if (neighbor.containsKey(cur)) {
            List<String> n = neighbor.get(cur); // must exist, since dfs follows produced path by bfs
            for(String v : n) {
                if(distance.get(v) == distance.get(cur) + 1) {
                    dfs(v, end, sol, res, neighbor, distance);
                }
            }
        }
        sol.remove(sol.size() - 1);
    }

    private List<String> getNeighbor(String u, Map<String, List<String>> neighbor, Set<String> dict) {
        if(neighbor.containsKey(u)) return neighbor.get(u);
        List<String> ls = new LinkedList<>();
        for(int i = 0; i < u.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                String v = mutate(u, i, c);
                if(dict.contains(v) && !u.equals(v)) ls.add(v);
            }
        }
        neighbor.put(u, new LinkedList<>(ls)); // store for performance
        return ls;
    }

    private String mutate(String o, int i, char c) {
        return o.substring(0, i) + ("" + c) + o.substring(i+1);
    }
}
