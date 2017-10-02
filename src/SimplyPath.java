import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhoucheng on 10/2/17.
 */
public class SimplyPath {
    public String simplifyPath(String path) {
        String[] pcs = path.split("/");
        List<String> dirs = new ArrayList<>();
        for(String s : pcs) {
            switch (s) {
                case "":
                    // do nothing
                    // break;
                case " ":
                    // do nothing
                    break;
                case ".":
                    // do nothing
                    break;
                case "..":
                    if(dirs.size() > 0) {
                        dirs.remove(dirs.size() - 1);
                    }
                    break;
                default:
                    dirs.add(s);
            }
        }
        StringBuilder s = new StringBuilder();
        for(String p : dirs) {
            s.append("/");
            s.append(p);
        }
        return s.toString();
    }


    public static void main(String[] args) {
        SimplyPath solution = new SimplyPath();
        solution.simplifyPath("/a/b/c");
    }
}
