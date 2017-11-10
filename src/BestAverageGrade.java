import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhoucheng on 11/3/17.
 */
public class BestAverageGrade {
    public int find(String[][] ns) {
        Map<String, Student> m = new HashMap<>();
        for(int i = 0; i < ns.length; i++) {
            if(m.containsKey(ns[i][0])) {
                Student s = m.get(ns[i][0]);
                s.anotherOne(Integer.valueOf(ns[i][1]));
            } else {
                Student s =  new Student();
                s.anotherOne(Integer.valueOf(ns[i][1]));
                m.put(ns[i][0], s);
            }
        }

        int max = 0;
        for (Map.Entry<String, Student> s : m.entrySet())
        {
            int avg = s.getValue().computeAvg();
            System.out.println(avg);
            if (avg > max) max = avg;
        }
        return max;
    }

    private class Student {
        private int grades;
        private int total;
        Student() {
            grades = 0;
            total = 0;
        }
        int computeAvg() {
            double g = grades;
            return (int)Math.floor(g/total);
        }

        void anotherOne(int g) {
            grades+=g;
            total++;
        }
    }

    public static void main(String[] args) {
        String[][] ns = {{"bob", "80"}, {"ted", "100"}, {"ted", "20"}};
        BestAverageGrade sol = new BestAverageGrade();
        System.out.println(sol.find(ns));
    }
}
