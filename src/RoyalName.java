import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 10/26/17.
 */
public class RoyalName {
    public String[] sort(String[] names) {
        RomanToInteger c = new RomanToInteger();
        List<String> ls = Arrays.asList(names);
        ls.sort((i1, i2) -> findName(i1).compareTo(findName(i2)));
        ls.sort((i1, i2) -> Integer.compare(c.romanToInt(findGen(i1)), c.romanToInt(findGen(i2))));
        names = ls.toArray(names);
        return names;
    }

    private String findName(String s) {
        return s.substring(0, s.indexOf(' '));
    }

    private String findGen(String s) {
        return s.substring(s.indexOf(' ')+1);
    }
}
