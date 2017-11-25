import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 11/16/17.
 */
public class BattleShipInAField {
    public int countBattleships(char[][] board) {
        List<String> ls = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        int num = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'X') {
                    if(hasLeft(board, i, j)) {
                        if(leftValue(board, i, j) == 'X') {
                            continue;
                        }
                    }
                    if(hasUp(board, i, j)) {
                        if(upValue(board, i, j) == 'X') {
                            continue;
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }

    private boolean hasLeft(char[][] board, int i, int j) {
        return j-1>=0;
    }

    private char leftValue(char[][] board, int i , int j) {
        return board[i][j-1];
    }
    private boolean hasUp(char[][] board, int i, int j) {
        return i-1>=0;
    }

    private char upValue(char[][] board, int i, int j) {
        return board[i-1][j];
    }
}
