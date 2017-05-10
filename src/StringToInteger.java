/**
 * Created by zhoucheng on 5/10/17.
 */
public class StringToInteger {
    int INT_MAX = 2147483647;
    int INT_MIN = -2147483648;

    public int myAtoi(String str) {
        try {

            str = clean(str);

            boolean negative = false;
            int len = str.length();
            int result = 0;
            if(len >= 1 && str.charAt(0) == '-') {
                negative = true;
                str = str.replaceFirst("\\-", "");
                len--;
            }
            else if(len >= 1 && str.charAt(0) == '+') {
                negative = false;
                str = str.replaceFirst("\\+", "");
                len--;
            }


            for (int i = 0; i < len; i++) {
                if(legal(str.charAt(i))) {
                    if(overflow(result, i, len, str.charAt(i))) {
                        return negative? INT_MIN : INT_MAX;
                    }
                    result += getNumber(i, len, str.charAt(i));
                } else {
                    // end, repair the magnify then return
                    return getRepaired(negative, i, len, result);
                }
            }
            return negative ? -1 * result: result;
        } catch(Exception e) {
            return 0;
        }

    }

    public int getNumber(int pos, int len, char charVal) {
        int magnify = (int)Math.pow(10, (len - 1 - pos));
        return magnify * ((int) charVal - 48);
    }

    public boolean legal(char charVal) {
        int ch = (int) charVal;
        if(ch < 48 || ch > 57)
            return false;
        return true;
    }

    public int getRepaired(boolean negative, int pos, int len, int toBeRepaired) {
        int shrink = (int) Math.pow(10, len - pos);
        return negative ? -1 * toBeRepaired/shrink : toBeRepaired/shrink;
    }

    public boolean overflow(int result, int pos, int len, char charVal) {
        double toAdd = (int)Math.pow(10, (len - 1 - pos)) * ((int) charVal - 48);
        if(toAdd > INT_MAX)
            return true;
        if((toAdd + result) > INT_MAX)
            return true;
        return false;
    }

    public String clean(String str) {
        str = str.trim();
        int len = str.length();
        int start = 0;
        if(len > 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            start = 1;
        }
        for(int i = start; i < len; i++) {
            if(!legal(str.charAt(i))) {
                return str.substring(0, i);
            }
        }
        return str;
    }
    public static void main(String[] args) {
        // write your code here
        // possible conditions:
        // 1. negatives
        // 2. out of bound
        // 3. illegal characters
        // 4. begins with zero
        StringToInteger solution = new StringToInteger();
        System.out.println(solution.myAtoi(" -1010023630o4"));

    }
}
