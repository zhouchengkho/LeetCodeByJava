import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateTwo {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if(Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    map.replace(nums[i], i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateTwo solution = new ContainsDuplicateTwo();
        int[] nums = {1, 3, 1, 1};
        int k = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}
