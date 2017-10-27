/**
 * Created by zhoucheng on 10/26/17.
 */
public class BarclaysPlay {
    public static void main(String[] args) {
        RoyalName s = new RoyalName();
        String[] names = {"Williams III", "Williams II", "Henry I", };
        names = (s.sort(names));
        for(int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}


