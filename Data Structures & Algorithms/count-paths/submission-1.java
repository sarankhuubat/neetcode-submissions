class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, m, n, cache);
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
