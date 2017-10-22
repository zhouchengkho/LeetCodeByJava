import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoucheng on 10/16/17.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length <= 1) return 0;
        int area = 0;
        // boolean edge = true;
        boolean done = false;
        int pos = 0;
        List<Integer> ls = findNextGap(pos, height);
        while(pos < height.length - 1) {
            if(ls.size() == 0 && pos < height.length - 1) {
                pos++;
                ls = findNextGap(pos, height);
            } else if(ls.size() == 2) {
                // found gap
                area+=computeGapArea(ls.get(0), ls.get(1), height);
                pos = ls.get(1);
                ls = findNextGap(pos, height);
            }
        }
        return area;
    }

    public List<Integer> findNextGap(int pos, int[] height) {
        List<Integer> ls = new ArrayList<>();
        if(pos == height.length - 1) return ls;
        int left = height[pos];
        int init = height[pos+1];
        for(int i = pos+1; i < height.length; i++) {
            if(height[i] >= left) {
                ls.add(pos);
                ls.add(i);
                return ls;
            }
        }
        // can't find a higher one, then try find the highest one in remaining
        int highest = pos+1;
        for(int i = pos+2; i < height.length; i++) {
            if(height[i] > height[highest]) {
                highest = i;
            }
        }
        ls.add(pos);
        ls.add(highest);
        return ls;
    }

    public int computeGapArea(int l, int r, int[] height) {
        int high = Math.min(height[l], height[r]);
        int area = 0;
        for(int i = l+1; i < r; i++) {
            area += (high - height[i]);
        }
        return area;
    }
}
