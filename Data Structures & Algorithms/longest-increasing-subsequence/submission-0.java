class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] cache = new int[nums.length][nums.length+1];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, -1, cache);
    }

    private int dfs(int[] nums, int i, int j, int[][] cache){
        if(i == nums.length){
            return 0;
        }

        if(cache[i][j + 1] != -1){
            return cache[i][j + 1];
        }

        int res = dfs(nums, i + 1, j, cache);
        if(j == -1 || nums[j] < nums[i]){
            res = Math.max(res, 1 + dfs(nums, i + 1, i, cache));
        }

        cache[i][j + 1] = res;
        return res;
    }
}
