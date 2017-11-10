/**
 * Created by zhoucheng on 11/4/17.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        // up, down
        for(int j = 0; j < col; j++) {
            if(board[0][j] == 'O') ppg(board, 0, j);
            if(board[row-1][j] == 'O') ppg(board, row-1, j);
        }
        // left, right
        for(int i = 1; i < row - 1; i++) {
            if(board[i][0] == 'O') ppg(board, i, 0);
            if(board[i][col-1] == 'O') ppg(board, i, col-1);
        }
        // print(board);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                board[i][j] = board[i][j] == '1' ? 'O' : 'X';
            }
        }
    }

    public void print(char[][] b) {
        int row = b.length;
        int col = b[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void ppg(char[][] b, int i, int j) {
        b[i][j] = '1';
        int[] dirs = {i, j-1, i, j+1, i-1, j, i+1, j};
        for(int k = 0; k < 8; k+=2) {
            int pi = dirs[k];
            int pj = dirs[k+1];
            if(inbound(b, pi, pj) && b[pi][pj] == 'O') {
                ppg(b, pi, pj);
            }
        }
    }

    public boolean inbound(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        return (i >= 0 && i <= row - 1 && j >= 0 && j <= col - 1);
    }
}
