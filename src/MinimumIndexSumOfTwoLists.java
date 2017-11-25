import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoucheng on 11/16/17.
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> ls2 = new HashMap<>();
        for(int i = 0; i < list2.length; i++) {
            ls2.put(list2[i], i);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++) {
            if(ls2.containsKey(list1[i])) {
                if(ls2.get(list1[i]) + i < min) {
                    min = ls2.get(list1[i]) + i;
                    result.clear();
                    result.add(list1[i]);
                } else if(ls2.get(list1[i]) + i == min) {
                    result.add(list1[i]);
                }
            }
        }

        String[] strarray = new String[result.size()];
        result.toArray(strarray);
        return strarray;
    }
}
