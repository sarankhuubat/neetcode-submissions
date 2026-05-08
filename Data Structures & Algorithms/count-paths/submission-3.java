class Solution {
    private int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        for(int[] c : cache){
            Arrays.fill(c, -1);
        }
        return helper(0, 0, m, n);
    }

    private int helper(int r, int c, int m, int n){
        if(r == m || c == n){
            return 0;
        }

        if(cache[r][c] != -1){
            return cache[r][c];
        }

        if(r == m - 1 && c == n - 1){
            return 1;
        }

        return cache[r][c] = helper(r + 1, c, m, n) + helper(r, c + 1, m, n);
    }
}
