import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");
        String result = "";
        int len = str.length;
        for(int i = len - 1; i >= 0; i--) {
            result = result.concat(str[i].trim()).concat(" ");
        }
        return result.trim();
    }

    private String popWord(Stack word, String s) {
        while(word.size() != 0) {
            s = s.concat(String.valueOf(word.pop()));
        }
        s = s.concat(" ");
        return s;
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        String s = " the sky is  blue ";
        System.out.println(solution.reverseWords(s));
    }
}
