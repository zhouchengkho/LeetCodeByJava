
public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // assume this is a sorted matrix
        // so use binary search to locate
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int hi = m*n - 1;
        int lo = 0;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(matrix[mid/n][mid%n] == target) {
                return true;
            } else if(matrix[mid/n][mid%n] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return false;
    }
}
