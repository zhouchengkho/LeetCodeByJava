import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by zhoucheng on 5/1/17.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int len = s.length();
        String[] storage = new String[numRows];
        for(int i = 0; i < storage.length;i++) {
            storage[i] = "";
        }
        for(int i = 0; i < len;) {
            // decide s[i] goes where
            String temp = s.substring(i, i + 1);
            int which = whichStorage(i, numRows);
            i++;
            storage[which] = storage[which].concat(temp);
        }
        String result = "";
        for(int i = 0; i < storage.length; i++) {
            result = result.concat(storage[i]);
        }
        return result;
    }


    public int whichStorage(int i, int numRows) {
        if(numRows == 1) return 0;

        int redundancy = (i+1) %  (2*numRows - 2);
        if(redundancy <= numRows && redundancy > 0) {
            return redundancy - 1;
        } else if (redundancy == 0){
            return 1;
        } else {
            System.out.println(2*numRows - redundancy);
            return 2*numRows - redundancy - 1;
        }
    }
    public static void main(String[] args) {
        // write your code here
        ZigZagConversion solution = new ZigZagConversion();
        System.out.println(solution.convert("PAYPALISHIRING", 3));

    }
}
