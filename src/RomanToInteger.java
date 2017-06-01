import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 6/1/17.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        List<String> strs = Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I");
        int[] nums = {  1000, 900,500,400, 100, 90, 50, 40,  10,  9,   5,  4,   1};
        int len = s.length();
        int result = 0;
        int i = 0;
        while(i < len) {
            String temp = String.valueOf(s.charAt(i));
            while(strs.contains(temp) && (i+1) < len && strs.contains(temp+String.valueOf(s.charAt(i+1)))) {
                temp+=String.valueOf(s.charAt(i+1));
            }
            i+=temp.length();
            result+=nums[strs.indexOf(temp)];
        }
        return result;
    }
    public static void main(String[] args) {
        // write your code here
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt("MMMCMXCIX"));
    }
}
