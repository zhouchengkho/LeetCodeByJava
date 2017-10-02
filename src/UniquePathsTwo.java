public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 0,0 -> m, n
         */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] map = new int[m][n];
        map[0][0] = 1;
        for(int i = 1; i < m; i++) {
            map[i][0] = map[i-1][0] == 1 && obstacleGrid[i][0] == 0 ? 1 : 0;
        }
        for(int i = 1; i < n; i++) {
            map[0][i] = map[0][i-1] == 1 && obstacleGrid[0][i] == 0 ? 1 : 0;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                map[i][j] = obstacleGrid[i][j] == 1 ? 0 : map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsTwo sol = new UniquePathsTwo();
        int[][] obs = {
                {1,0}
        };
        System.out.println(sol.uniquePathsWithObstacles(obs));
    }
}
