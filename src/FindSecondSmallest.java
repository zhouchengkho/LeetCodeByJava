/**
 * Created by zhoucheng on 11/3/17.
 */
public class FindSecondSmallest {
    public int find(int[] a) {
        int pivot = a.length/2;
        int min1 = findInIndex(a, 0, pivot);
        int min2 = findInIndex(a, pivot, a.length);
        if(min1 < min2) {
            int min3 = findInIndexExclude(a, min1, 0, pivot);
            return Math.min(min2, min3);
        } else {
            int min3 = findInIndexExclude(a, min2, pivot, a.length);
            return Math.min(min1, min3);
        }
    }

    public int findInIndex(int[] a, int s, int e) {
        int min = Integer.MAX_VALUE;
        for(int i = s; i < e; i++) {
            if(a[i] < min) min = a[i];
        }
        return min;
    }

    public int findInIndexExclude(int[] a, int ex, int s, int e) {
        int min = Integer.MAX_VALUE;
        for(int i = s; i < e; i++) {
            if(a[i] < min && a[i] != ex) min = a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        FindSecondSmallest sol = new FindSecondSmallest();
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sol.find(a));
    }
}
