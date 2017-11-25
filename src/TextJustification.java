import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 11/16/17.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // take words in a gready way
        // taking two words in, should have one space
        // three words: least two spaces
        // space = words - 1
        // words length + space <= maxWidth

        List<String> result = new LinkedList<>();
        List<String> line = new LinkedList<>();
        int used = 0;
        for(int i = 0; i < words.length; i++) {
            line.add(words[i]);
            used+=words[i].length();
            if(!ok(line, used, maxWidth)) {
                line.remove(line.size()-1);
                i--;
                result.add(append(line, maxWidth));
                line.clear();
                used = 0;
            }
        }
        if(line.size() > 0) {
            // this should be spcially treated
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < line.size() - 1; i++) {
                sb.append(line.get(i));
                sb.append(' ');
            }
            sb.append(line.get(line.size()-1));
            sb.append(blanks(sb.toString(), maxWidth));
            result.add(sb.toString());
        }
        return result;
    }

    private boolean ok(List<String> words, int wordLens, int maxWidth) {
        int spaces = words.size() >= 1 ? words.size() - 1 : 0;
        return wordLens+spaces <= maxWidth;
    }

    private String append(List<String> words, int maxWidth) {
        int len = 0;
        for(int i = 0;i < words.size(); i++) {
            len+=words.get(i).length();
        }
        if(words.size() == 1) {
            return words.get(0) + blanks(words.get(0), maxWidth);
        }
        int spaces = words.size() - 1;
        int countOfOneMore = (maxWidth-len)%spaces;
        int howMany = (maxWidth-len)/spaces;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if(i<=spaces-1) {
                sb.append(genBlanks(howMany));
                if(countOfOneMore > 0) {
                    sb.append(' ');
                    countOfOneMore--;
                }
            }
        }
        return sb.toString();
    }

    private String blanks(String s, int maxWidth) {
        int len = maxWidth - s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private String genBlanks(int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private void print(List<String> line) {
        for(int i = 0; i < line.size(); i++) {
            System.out.print(line.get(i)+" ");
        }
        System.out.println();
    }


}
