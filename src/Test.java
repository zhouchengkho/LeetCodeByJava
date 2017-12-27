import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * useful stuff
 *
 * regex : see ReverseWordsInAString
 *
 * proper binary search: see SearchATwoDMatrix
 *
 *
 *
 * // parse char to int
 * char to int (int) ch - 48
 *
 *
 * // parse things to int
 * Integer.parseInt
 *
 *
 *
 * // int to string
 * String.valueOf()
 *
 *
 *
 * Queue<TreeNode> q = new LinkedList<>();
 *
 *
 *
 * // map iteration
 * for (Map.Entry<String, String> entry : h.entrySet())
 * {
 *      System.out.println(entry.getKey() + "/" + entry.getValue());
 * }
 *
 * // set iteration
 * for(Type t : set) {}
 *
 * intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
 *
 *
 *
 * bit manipulation
 * a << b, mv a's bit to left b bits
 * a >> b, mv a's bit to right b bits
 *
 *
 *
 * */
public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        int[] nums = {75, 72};
        put(nums, map);


        System.out.println(map.ceilingEntry(68));
        Map.Entry<Integer, String> e = map.ceilingEntry(68);
    }

    private static void put(int[] nums, TreeMap<Integer, String> map) {
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], String.valueOf(i));
        }
    }

    static boolean isBefore(String d1, String d2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null; Date date2 = null;
        try
        {
            date1 = format.parse(d1); date2 = format.parse(d2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return date1.before(date2);
    }


    static void change(int[][] b) {
        b[0][0] = 2;
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
