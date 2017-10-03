import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * useful stuff
 *
 * regex : see ReverseWordsInAString
 *
 * proper binary search: see SearchATwoDMatrix
 *
 * */
public class Test {
    public static void main(String[] args) {
        int test = 1;
        int[] board = {1, 2, 3, 4};
        System.out.println(board[0]);
        System.out.println(board[0]^=256);
        System.out.println(board[0]);
        System.out.println(board[0]^=256);
    }

    static String findNumber(int[] arr, int k) {
        boolean found = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == k) {
                found = true;
                break;
            }
        }
        return found ? "YES" : "NO";
    }

    static int[] oddNumbers(int l, int r) {
        if(r < l) return new int[0];
        int start = l;
        if(start%2 == 0) {
            start++;
        }
        int len = (r - l)/2;
        if(r%2 == 1 || l%2 == 1)
            len++;
        int[] ls = new int[len];
        for(int i = 0; i < len; i++) {
            ls[i] = start;
            start+=2;
        }
        return ls;
    }

    static String compute(String s) {
        int bigPos = 0;
        if(s.length() <= 1) return s;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > s.charAt(bigPos)) {
                bigPos = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bigPos; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    void track(String s, List<Character> ls, int i) {
        if(i < ls.size() - 1) {

        }
    }

    static String[] getSortedList(String[] names) {
        List<String> ls = Arrays.asList(names);
        // ls.sort((i1, i2) -> Integer.compare(romanToInt(i1.substring(i1.indexOf(' ')+1)), romanToInt(i2.substring(i2.indexOf(' ')+1))));
        ls.sort((i1, i2) -> i1.substring(0, i1.indexOf(' ')).compareTo(i2.substring(0, i2.indexOf(' '))));
        names = ls.toArray(names);
        return names;
    }



    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        int[] result = new int[maxes.length];
        Arrays.fill(result, nums.length);
        for(int i = 0; i < maxes.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] > maxes[i]) {
                    result[i] = j;
                    break;
                } else if(nums[j] == maxes[i]) {
                    if(j < nums.length - 1 && nums[j] == nums[j+1]) continue;
                    result[i] = j+1;
                    break;
                }
            }


        }
        return result;
    }
}
