import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoucheng on 10/3/17.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(!found) track(board, new int[]{i, j}, word, 0, map);
            }
        }
        return found;
    }

    private boolean found = false;
    private void track(char[][] board, int[] pos, String word, int matchPos, Map<Integer, Boolean> map) {
        if(!found) {
            int rowLen = board.length;
            int colLen = board[0].length;
            int key = pos[0]*colLen + pos[1];
            if(
                    pos[0] >= 0 && pos[0] <= rowLen-1 && pos[1] >=0 &&
                            pos[1] <= colLen-1 && board[pos[0]][pos[1]] == word.charAt(matchPos) &&
                            !map.containsKey(key)
                    ) {
                matchPos++;
                map.put(key, true);
                if(matchPos == word.length()) {
                    found = true;
                } else {
                    int[] neighbors = {pos[0]-1, pos[1], pos[0], pos[1]-1,
                            pos[0], pos[1]+1, pos[0]+1, pos[1]};
                    for(int i = 0; i < neighbors.length;i+=2) {
                        int row = neighbors[i];
                        int col = neighbors[i+1];
                        track(board, new int[]{row, col}, word, matchPos, map);
                    }
                    map.remove(key);
                }
            }
        }
    }
}
