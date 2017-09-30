/**
 * Created by zhoucheng on 9/29/17.
 */
public class SetMatrixZeroes {
    public void setZeros(int[][] matrix) {
        int col0 = 1;
        int row0 = 1;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;


        // special
        if(matrix[0][0] == 0) {
            row0 = 0;
            col0 = 0;
        }
        for(int j = 1; j < colLen; j++) {
            if(matrix[0][j] == 0) row0 = 0;
        }
        for(int i = 1; i < rowLen; i++) {
            if(matrix[i][0] == 0) col0 = 0;
        }


        // regular
        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // change regular
        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        // change special
        if(row0 == 0) {
            for(int j = 0; j < colLen; j++) matrix[0][j] = 0;
        }
        if(col0 == 0) {
            for(int i = 0; i < rowLen; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 5, 2},
                {8, 9, 2, 0},
                {5, 7, 2, 1}
        };
        solution.setZeros(matrix);
    }
}
