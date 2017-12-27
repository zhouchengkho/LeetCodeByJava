/**
 * Created by zhoucheng on 12/13/17.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int bit = 0;
        int orNum = 0;
        while(num > (Math.pow(2, bit) * 2 -1)) {
            bit++;
        }
        orNum = (int)(Math.pow(2, bit) * 2 -1);
        return num^orNum;

    }
}
