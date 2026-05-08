class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSum = new ArrayList<>();
        int sum = 0;
        helper(result, currSum, target, nums, sum, 0);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> currSum, int target, int[] nums, int sum, int start){
        if(sum > target || start >= nums.length) return;
        if(sum == target){
            result.add(new ArrayList(currSum));
            return;
        } else {
            currSum.add(nums[start]);
            helper(result, currSum, target, nums, sum+nums[start], start);
            currSum.remove(currSum.size()-1);

            helper(result, currSum, target, nums, sum, start + 1);
        }
    } 
}
