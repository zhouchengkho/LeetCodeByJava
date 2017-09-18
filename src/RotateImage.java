/**
 * Created by zhoucheng on 9/18/17.
 */
public class RotateImage {
    // suitable for n*n square
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int level = (n + 1) / 2;
        for(int cl = 0; cl < level; cl++) {
            int smallN = n - cl*2;
            for(int i = 0; i < smallN - 1; i++) {
                circleSwap(i, cl, matrix);
            }
        }
    }

    private void circleSwap(int i, int level, int[][] matrix) {
        int n = matrix[0].length;
        int pos1[] = {level, i + level};
        int pos4[] = {n - 1 - level - i, level};
        int pos3[] = {n - 1 - level, n - 1 - level - i};
        int pos2[] = {i + level, n - 1 - level};
        int temp = matrix[pos1[0]][pos1[1]];
//        System.out.println("pos for level "+level+" at i "+i+": "+pos1[0]+" "+pos1[1]+" "+pos2[0]+" "+pos2[1]+" "+pos3[0]+" "+pos3[1]+" "+pos4[0]+" "+pos4[1]);
        matrix[pos1[0]][pos1[1]] = matrix[pos4[0]][pos4[1]];
        matrix[pos4[0]][pos4[1]] = matrix[pos3[0]][pos3[1]];
        matrix[pos3[0]][pos3[1]] = matrix[pos2[0]][pos2[1]];
        matrix[pos2[0]][pos2[1]] = temp;
    }

    private void printSquare(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
//        int[][] matrix = {
//                {5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}
//        };
        RotateImage solution = new RotateImage();
        solution.printSquare(matrix);
        System.out.println();
        solution.rotate(matrix);
        solution.printSquare(matrix);
    }
}
