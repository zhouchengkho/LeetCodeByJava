public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from 0 at both arrays
        // compare, put the smaller one in, then move pointer
        int[] nums1t = new int[m+n];
        System.arraycopy(nums1, 0, nums1t, 0, m+n);
        int p1 = 0;
        int p2 = 0;
        while(p1 < m || p2 < n) {
            if(p1 == m && p2 < n) {
                nums1[p1+p2] = nums2[p2];
                p2++;
            } else if(p1 < m && p2 == n) {
                nums1[p1+p2] = nums1t[p1];
                p1++;
            } else {
                if(nums1t[p1] < nums2[p2]) {
                    nums1[p1+p2] = nums1t[p1];
                    p1++;
                } else {
                    nums1[p1+p2] = nums2[p2];
                    p2++;
                }
            }
        }
    }
}
