import java.util.Arrays;

/**
 * Created by zhoucheng on 9/21/17.
 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(result[i], 0);
        }
        if(n == 0) return result;
        int i = 0;
        int j = 0;
        result[i][j] = 1;
        int totalFilled = 1;
        int currentDir = 0;
        while(totalFilled < n*n) {
            switch(currentDir) {
                case 0:
                    if(j + 1 >= n || result[i][j + 1] != 0) {
                        i++;
                        currentDir = 1;
                    } else {
                        j++;
                    }
                    break;
                case 1:
                    if(i + 1 >= n || result[i + 1][j] != 0) {
                        j--;
                        currentDir = 2;
                    } else {
                        i++;
                    }
                    break;
                case 2:
                    if(j - 1 < 0 || result[i][j - 1] != 0) {
                        i--;
                        currentDir = 3;
                    } else {
                        j--;
                    }
                    break;
                case 3:
                    if(i - 1 < 0 || result[i - 1][j] != 0) {
                        j++;
                        currentDir = 0;
                    } else {
                        i--;
                    }
                    break;
            }
            totalFilled++;
            result[i][j] = totalFilled;
        }
        return result;
    }

    public void print(int[][] result) {
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralMatrixTwo solution = new SpiralMatrixTwo();
        int n = 3;
        solution.print(solution.generateMatrix(n));
    }
}
