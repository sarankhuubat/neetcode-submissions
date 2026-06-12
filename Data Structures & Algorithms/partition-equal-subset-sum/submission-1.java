class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int n : nums){
            totalSum += n;
        }

        if(totalSum%2 != 0){
            return false;
        }
        memo = new Boolean[nums.length][totalSum/2 + 1];
        
        return dfs(0, totalSum/2, nums);
    }

    private boolean dfs(int n, int target, int[] nums){
        if(n == nums.length)
            return target == 0;

        if(target < 0)
            return false;

        if(memo[n][target] != null){
            return memo[n][target];
        }
        
        return memo[n][target] = dfs(n + 1, target, nums) || dfs(n + 1, target - nums[n], nums);
    }
}
