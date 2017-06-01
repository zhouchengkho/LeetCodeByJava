/**
 * Created by zhoucheng on 6/1/17.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {  1000, 900,500,400, 100, 90, 50, 40,  10,  9,   5,  4,   1};
        String result = "";
        for(int i = 0; i < strs.length; i++) {
            while(num >= nums[i]) {
                num-=nums[i];
                result+=strs[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // write your code here
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman(3999));
    }
}
