import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoucheng on 10/16/17.
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ls = new ArrayList<>();
        if(s.length() > 12) return ls;
        track(ls, 0, s, new ArrayList<>());
        return ls;
    }

    private void track(List<String> ls, int pos, String s, List<String> temp) {
        if(temp.size() == 4 && pos == s.length()) {
            String toAdd = genString(temp);
            if(toAdd.length() == s.length() + 3)
                ls.add(genString(temp));
        } else {
            for(int i = pos; i < s.length(); i++) {
                for(int j = 1; j <= 3; j++) {
                    if(pos+j <= s.length()) {
                        String t = s.substring(pos, pos+j);
                        if(isValid(t)) {
                            temp.add(t);
                            track(ls, i+j, s, temp);
                            temp.remove(temp.size() - 1);
                        }
                    }
                }
            }
        }
    }


    private String genString(List<String> temp) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < temp.size(); i++) {
            s.append(temp.get(i));
            s.append(".");
        }
        String r = s.toString();
        return r.substring(0, r.length() - 1);
    }

    private boolean isValid(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        int addr = Integer.parseInt(s);
        return addr <= 255 && addr >=0;
    }
}
