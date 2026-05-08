class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for(int r = m - 1; r >= 0; r--){
            for(int c = n - 1; c >= 0; c--){
                dp[r][c] += dp[r][c + 1] + dp[r + 1][c];
            }
        }
        
        return dp[0][0];
    }

    private int dfs(int row, int col, int m, int n, int[][] cache){
        if(row == m || col == n){
            return 0;
        }

        if(row == m - 1 || col == n - 1){
            return 1;
        }

        if(cache[row][col] != -1){
            return cache[row][col];
        }


        return cache[row][col] = dfs(row + 1, col, m, n, cache) + dfs(row, col + 1, m, n, cache);

        //return cnt;
    }
}
