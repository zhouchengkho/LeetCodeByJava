import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
