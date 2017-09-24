import java.util.ArrayList;
import java.util.List;


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals = orderByStart(intervals);
        List<Interval> result = new ArrayList<>();
        if(intervals.size() <= 1) return intervals;
        result.add(intervals.get(0));
        for(Interval interval : intervals) {
            if(interval.start <= result.get(result.size() - 1).end) {
                int s = result.get(result.size() - 1).start;
                int e = Math.max(result.get(result.size() - 1).end, interval.end);
                result.set(result.size() - 1, new Interval(s, e));
            } else {
                result.add(new Interval(interval.start, interval.end));
            }
        }
        return result;
    }

    private List<Interval> orderByStart(List<Interval> intervals) {
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        return intervals;
    }

    public void print(List<Interval> intervals) {
        for(Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
    public static void main(String[] args) {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        List<Interval> ls = new ArrayList<>();
        ls.add(c); ls.add(b); ls.add(a);
        MergeIntervals solution = new MergeIntervals();
        solution.print(solution.merge(ls));
    }
}
