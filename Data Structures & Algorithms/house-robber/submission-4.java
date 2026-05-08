class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for(int i = 0; i < nums.length;  i++){
            cache[i] = -1;
        }
        return dfs(0, nums, cache);
    }

    private int dfs(int i, int[] nums, int[] cache){
        if(i >= nums.length){
            return 0;
        }
        if(cache[i] != -1) return cache[i];

        return cache[i] = Math.max(dfs(i+1, nums,cache), nums[i] + dfs(i+2, nums, cache));
        
    }
}
