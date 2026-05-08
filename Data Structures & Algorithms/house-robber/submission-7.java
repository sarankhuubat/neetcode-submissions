class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length-1];
    }

    private int dfs(int i, int[] nums, int[] cache){
        if(i >= nums.length){
            return 0;
        }

        if(cache[i] != -1) return cache[i];

        return cache[i] = Math.max(dfs(i + 1, nums, cache), nums[i] + dfs(i + 2, nums, cache));
    }
}
