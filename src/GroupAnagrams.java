import java.util.*;


public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            if(map.containsKey(String.valueOf(c))) {
                map.get(String.valueOf(c)).add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(String.valueOf(c), new ArrayList<>(tempList));
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}
