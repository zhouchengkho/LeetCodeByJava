import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/9/17.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            int num = i ^ i>>1;
            System.out.println(i+", "+ (i>>1) +", "+num);
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1<<1);
    }
}
