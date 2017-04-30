import static java.lang.StrictMath.max;
import static java.lang.StrictMath.min;



/**
 * Created by zhoucheng on 4/30/17.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int INT_MAX = 2147483647;
        final int INT_MIN = -2147483648;

        int N1 = nums1.length;
        int N2 = nums2.length;

        if(N1 > N2)
            return findMedianSortedArrays(nums2, nums1);

        if(N1 == 0)
            return (nums2[(N2-1)/2] + nums2[N2/2]) / 2.0;
        int low = 0; int high = 2 * N1;
        while(low <= high) {
            int C1 = (low + high) / 2;
            int C2 = N1 + N2 - C1;

            int L1 = (C1 == 0) ? INT_MIN : nums1[(C1 - 1) / 2];
            int R1 = (C1 == 2 * N1) ? INT_MAX : nums1[C1 / 2];
            int L2 = (C2 == 0) ? INT_MIN : nums2[(C2 - 1) / 2];
            int R2 = (C2 == 2 * N2) ? INT_MAX : nums2[C2 / 2];

            // this is binary search
            if(L1 > R2) high = C1 - 1;
            else if(L2 > R1) low = C1 + 1;
            else return (min(R1, R2) + max(L1, L2)) / 2.0;
        }

        return -1;
    }




    /**
     *
     * k is the middle number when sorted
     * find L1, R1, L2, R2
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {3};
        int[] nums2 = {1, 2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
