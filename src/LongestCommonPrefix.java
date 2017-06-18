/**
 * Created by zhoucheng on 6/11/17.
 */
public class LongestCommonPrefix {
    Boolean startWith(String str, String piece) {
        return str.contains(piece) && str.substring(0, piece.length()).equals(piece);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs[0].length() == 0) {
            return "";
        }
        String piece = "";
        Boolean flag = true;
        while(flag) {
            for(String str:strs){
                if(!startWith(str, piece)) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                piece = strs[0].substring(0, piece.length()-1);
            }
            if(flag && strs[0].length() > piece.length()) {
                piece = strs[0].substring(0, piece.length()+1);
            } else if(flag && strs[0].length() == piece.length()) {
                flag = false;
            }

        }
        return piece;
    }
    public static void main(String[] args) {
        // write your code here
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] test = {"a", "b"};
        System.out.println(solution.longestCommonPrefix(test));
    }
}
