/**
 * Created by zhoucheng on 9/30/17.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // dead -> dead 0
        // dead -> live 2
        // live -> dead 1
        // live -> live 3
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int count = getLiveNeighborsCount(i, j, board);
                if(board[i][j] == 1) {
                    if(count < 2 || count > 3) {
                        // live -> dead
                        board[i][j] = 1;
                    } else {
                        // live -> live
                        board[i][j] = 3;
                    }
                } else {
                    if(count == 3) {
                        // dead -> live
                        board[i][j] = 2;
                    } else {
                        // dead -> dead
                        board[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                board[i][j] = board[i][j]/2;
            }
        }

    }

    private int getLiveNeighborsCount(int i, int j, int[][] board) {
        int[] poses = {i-1, j-1, i-1, j, i-1, j+1, i, j-1, i, j+1, i+1, j-1, i+1, j, i+1, j+1};
        int count = 0;
        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;
        for(int k = 0; k < poses.length; k+=2) {
            int row = poses[k];
            int col = poses[k+1];
            boolean ok = !(row < 0 || row > maxRow || col < 0 || col > maxCol) && board[row][col]%2 == 1;
            if(ok) {
                count++;
            }
        }
        return count;
    }
}
