class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private int dfs(int row, int col, int m, int n){
        if(row == m || col == n){
            return 0;
        }

        if(row == m - 1 || col == n - 1){
            return 1;
        }

        return dfs(row + 1, col, m, n) + dfs(row, col + 1, m, n);

        //return cnt;
    }
}
