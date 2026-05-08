class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        for(int i = 0; i < n; i++){
            cache[i] = -1;
        }
        
        return helper(0, n, cache);
    }

    private int helper(int i, int n, int[] cache){
        if(i >= n) return i == n ? 1 : 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = helper(i + 1, n, cache) + helper(i + 2, n, cache);
    }
}
