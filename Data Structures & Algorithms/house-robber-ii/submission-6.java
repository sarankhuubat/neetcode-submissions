class Solution {
    int[][] cache;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        cache = new int[nums.length][2];
        for(int[] c : cache){
            Arrays.fill(c, -1);
        }
        return Math.max(helper(0, 1, nums), helper(1, 0, nums));
    }

    private int helper(int i, int flag, int[] nums){
        if(i >= nums.length || (flag == 1 && i == nums.length - 1)) return 0;
        if(cache[i][flag] != -1) return cache[i][flag];
        return cache[i][flag] = Math.max(helper(i + 1, flag, nums), nums[i] + helper(i + 2, flag, nums));

    }
}
