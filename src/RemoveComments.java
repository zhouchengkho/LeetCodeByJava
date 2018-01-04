import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 1/3/18.
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> ls = new LinkedList<>();
        mc = false;
        for(int i = 0; i < source.length; i++) {
            boolean oldMc = mc;
            String line = cleanLine(source[i]);
            if(line.length() > 0) {
                if(oldMc && ls.size() > 0) {
                    String last = ls.get(ls.size() - 1);
                    ls.remove(ls.size() - 1);
                    ls.add(last + line);
                } else {
                    ls.add(line);
                }
            }
        }
        return ls;
    }
    private boolean mc;

    private String cleanLine(String s) {
        if(mc) {
            int mIndex = s.indexOf("*/");
            if(mIndex == -1) return "";
            mc = false;
            return cleanLine(s.substring(mIndex + 2));
        } else {
            int mIndex = s.indexOf("/*");
            int sIndex = s.indexOf("//");
            if(mIndex == -1 && sIndex == -1) return s;
            if(sIndex == -1 || (mIndex != -1 && mIndex < sIndex)) {
                mc = true;
                return s.substring(0, mIndex) + cleanLine(s.substring(mIndex + 2));
            } {
                // line ignored
                return s.substring(0, sIndex);
            }
        }
    }
}
