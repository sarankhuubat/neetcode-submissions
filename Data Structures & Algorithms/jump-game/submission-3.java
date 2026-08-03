class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for(int i = n - 2; i >= 0; i--){
            int end = Math.min(n, i + nums[i] + 1);
            for(int j = i + 1; j < end; j++){
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    private boolean dfs(int[] nums, int i, Map<Integer, Boolean> memo){
        if(memo.containsKey(i)){
            return memo.get(i);
        }

        if(i == nums.length - 1){
            return true;
        }

        if(nums[i] == 0){
            return false;
        }

        int end = Math.min(nums.length - 1, i + nums[i]);
        for(int j = i + 1; j <= end; j++){
            if(dfs(nums, j, memo)){
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);
        return false;
    }
}
