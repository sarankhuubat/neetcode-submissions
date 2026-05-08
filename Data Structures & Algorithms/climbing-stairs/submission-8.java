class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n-1];
    }

    private int dfs(int i, int n, int[] cache){
        if(i >= n) return i == n ? 1 : 0;

        if(cache[i] != -1) return cache[i];

        return cache[i] = dfs(i + 1, n, cache) + dfs(i + 2, n, cache);
    }
}
