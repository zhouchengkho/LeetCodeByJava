import java.util.LinkedList;

/**
 * Created by zhoucheng on 12/24/17.
 */
public class Asteroids {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                s.pollLast();
            if (s.isEmpty() || i > 0 || s.getLast() < 0)
                s.add(i);
            else if (i < 0 && s.getLast() == -i)
                s.pollLast();
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
