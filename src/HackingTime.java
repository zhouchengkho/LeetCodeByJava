/**
 * Created by zhoucheng on 11/11/17.
 */
public class HackingTime {
    String getRepeatedKey(String text) {
        text = text.substring(text.length() - 18, text.length());
        String origin = "Your friend, Alice";
        String forward = "000000000000000";
        int pos = 0;
        for(int i = 0; i < text.length();i++) {
            if(isAlpha(text.charAt(i))) {
                char c = intToChar(findDiff(origin.charAt(i), text.charAt(i)));
                forward = replace(forward, pos, c);
                pos++;
            } else  {
                // don't do anything
            }
        }

        // now got the forward string
        return forward;
    }
    String decrypt(String text) {
        // String repeatedKey = getRepeatedKey(text);
        String key = "2512208";

        int p = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if(isAlpha(text.charAt(i))) {
                int num = (key.charAt(p) - 48);
                char backed = back(text.charAt(i), num);
                sb.append(backed);
                p = next(key, p);
            } else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    int findDiff(char a, char b) {
        int count = 0;
        if(a < b) {
            while(a!=b) {
                a++;
                count++;
            }
        } else if (a > b){
            a-=26;
            return findDiff(a, b);
        } else {
            return 0;
        }
        return count;
    }

    boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    String replace(String s, int pos, char c) {
        return s.substring(0, pos) + String.valueOf(c) + s.substring(pos+1, s.length());
    }

    char intToChar(int n) {
        return (char)(n+'0');
    }

    char back(char c, int n) {
        char temp = c-=n;
        if (c >= 'a' && c <= 'z') {
            if(temp < 'a') {
                temp+=26;
            }

        } else {
            if(temp < 'A') {
                temp+=26;
            }
        }
        return temp;
    }

    char forward(char c, int n) {
        char temp = c+=n;
        if (c >= 'a' && c <= 'z') {
            if(temp > 'z') {
                temp-=26;
            }

        } else {
            if(temp > 'Z') {
                temp-=26;
            }
        }
        return temp;
    }
    int next(String key, int now) {
        if (now == key.length() - 1) {
            return 0;
        } else {
            return now+1;
        }
    }
    public static void main(String[] args) {
        // String t = "Your friend, Alice";
        String text = "-Atvt hr";
        HackingTime sol = new HackingTime();
        System.out.println(sol.decrypt(text));

    }
}
