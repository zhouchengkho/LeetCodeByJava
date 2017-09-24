import sun.jvm.hotspot.utilities.PlatformInfo;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = 0;
        for(; i < digits.length; i++) {
            digits[digits.length - i - 1]++;
            if(digits[digits.length - i - 1] == 10) {
                digits[digits.length - i - 1] = 0;
            } else {
                break;
            }
        }
        if(i == digits.length && digits[digits.length - 1] == 0) {
            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] digits = {9, 9, 9};
        digits = solution.plusOne(digits);
        for(int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
    }
}
