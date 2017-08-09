/**
 * Created by zhoucheng on 8/2/17.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int matchLen = needle.length();
        if(matchLen == 0) {
            return 0;
        }
        for(int i = 0;i<len;i++) {
            try {
                String temp = haystack.substring(i, i+matchLen);
                if(temp.equals(needle)) {
                    return i;
                }
            } catch(Exception e) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        String haystack = "aaa";
        String needle = "aaaa";
        System.out.println(solution.strStr(haystack, needle));
    }
}
