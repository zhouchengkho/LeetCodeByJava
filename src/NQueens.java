import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoucheng on 10/10/17.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ls = new ArrayList<>();
        int[][] b = new int[n][n];
        for(int i = 0; i < b.length; i++) {
            Arrays.fill(b[i], 0);
        }
        track(ls, b, 0);
        return ls;
    }

    private void track(List<List<String>> ls, int[][] b, int r) {
        int n = b.length;
        // print(b);
        // System.out.println("now track row: "+r);
        if(r == b.length) {
            ls.add(genBoard(b));
        } else {
            for(int j = 0; j < n; j++) {
                if(canOccupy(b, r, j)) {
                    // System.out.println("can occupy: "+r+", "+j);
                    track(ls, occupy(b, r, j), r+1);
                }
            }
        }
    }

    private void print(int[][] b) {
        int n = b.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    private boolean canOccupy(int[][] b, int row, int col) {
        int n = b.length;
        return b[row][col] == 0;

    }
    private int[][] occupy(int[][] b, int row, int col) {
        int n = b.length;
        int[][] cpy = new int[n][n];
        for(int i = 0; i < n; i++) {
            cpy[i] = b[i].clone();
        }
        // vertical, horizontal
        for(int i = 0; i < b.length; i++) {
            cpy[row][i] = 1;
            cpy[i][col] = 1;
        }
        // slant --
        int r = row - 1;
        int c = col - 1;
        while(r >= 0 && c >= 0) {
            cpy[r][c] = 1;
            r--;
            c--;
        }
        // slant ++
        r = row + 1;
        c = col + 1;
        while(r <= n-1 && c <= n-1) {
            cpy[r][c] = 1;
            r++;
            c++;
        }

        r = row + 1;
        c = col - 1;
        while(r <= n-1 && c >= 0) {
            cpy[r][c] = 1;
            r++;
            c--;
        }

        r = row - 1;
        c = col + 1;
        while(r >= 0 && c <= n-1) {
            cpy[r][c] = 1;
            r--;
            c++;
        }
        cpy[row][col] = 2;
        return cpy;
    }

    private List<String> genBoard(int[][] b) {
        int n = b.length;
        List<String> ls = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++) {
                s.append(b[i][j] == 2 ? 'Q' : '.');
            }
            ls.add(s.toString());
        }
        return ls;
    }
}
