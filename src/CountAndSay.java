import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by zhoucheng on 8/10/17.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        if(n <= 1) {
            return result;
        }
        while(n > 1) {
            result = say(result);
            n--;
        }
        return result;
    }

    private String say(String str) {
        String result = "";
        int len = str.length();
        int count = 1;
        for(int i = 0; i <= len - 1; i++) {
            char c = str.charAt(i);
            if(i != len-1) {
                if(str.charAt(i+1) == c) {
                    count++;
                } else {
                    result+= String.valueOf(count) + String.valueOf(c);
                    count = 1;
                }
            } else {
                result+= String.valueOf(count) + String.valueOf(c);
                count = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        int n = 6;
        System.out.println(solution.countAndSay(n));
    }
}
