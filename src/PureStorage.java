import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by zhoucheng on 1/13/18.
 */
public class PureStorage {
    public int countPalindromes(String s) {
        int mid = 0;
        char[] str = s.toCharArray();
        int count = 0;
        while(mid < str.length) {
            // mid ignored
            int lo = mid - 1;
            int hi = mid + 1;
            count+=count(str, lo, hi);


            // mid included
            lo = mid - 1;
            hi = mid;
            count+=count(str, lo, hi);

            mid++;
        }
        return count + str.length;
    }

    private int count(char[] str, int lo, int hi) {
        int count = 0;
        while(lo >= 0 && hi < str.length && str[lo] == str[hi]) {
            count++;
            lo--;
            hi++;
        }
        return count;
    }


    public int checkSequence(String[] events) {
        Stack<String> acquired = new Stack<>();
        Set<String> record = new HashSet<>();
        for(int i = 0; i < events.length; i++) {
            String[] e = events[i].split(" ");
            String type = e[0];
            String lock = e[1];
            int line = i+1;
            if(type.equals("ACQUIRE")) {
                // acquire

                // acquiring acquired locks
                if(record.contains(lock)) return line;

                // safe to acquire
                acquired.push(lock);
                record.add(lock);
            } else {
                // release

                // error release
                if(acquired.isEmpty() || !acquired.peek().equals(lock)) return line;

                // safe to release
                acquired.pop();
                record.remove(lock);
            }

        }

        return 0;
    }




    public static void main(String[] args) {
        PureStorage sol = new PureStorage();
        String s = "hellolle";

        int[] elements = new int[]{1,2,3,4,5};
        int target = 3;





        System.out.println(0 | 1);
        System.out.println(3 | 1);
        System.out.println(3 | 4);
        System.out.println(3 | 5);

    }


}
