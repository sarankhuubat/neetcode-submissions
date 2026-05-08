class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for(int i : nums){
            curSum = Math.max(curSum, 0) + i;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
