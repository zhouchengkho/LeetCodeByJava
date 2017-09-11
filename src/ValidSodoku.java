import java.util.HashSet;

/**
 * Created by zhoucheng on 9/5/17.
 */
public class ValidSodoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cubes = new HashSet<Character>();
            char empty = '.';
            for(int j = 0; j < 9; j++) {
                // rows and columns
                if( (board[i][j] != empty && !rows.add(board[i][j])) || (board[j][i] != empty && !columns.add(board[j][i])) ) {
                    return false;
                }
                // cubes
                int rowStart = 3 * (i/3);
                int colStart = 3 * (i%3);
                int rowIndex = rowStart + j/3;
                int colIndex = colStart + j%3;
                System.out.println("test: "+rowIndex+" "+colIndex);
                if(board[rowIndex][colIndex] != empty && !cubes.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidSodoku solution = new ValidSodoku();
        char[][] board = {
                // ["..5.....6","....14...",".........",".....92..","5....2...",".......3.","...54....","3.....42.","...27.6.."]
                {}, {}, {},
                {}, {}, {},
                {}, {}, {}
        };
        System.out.println(solution.isValidSudoku(board));
    }
}
