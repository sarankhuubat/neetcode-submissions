class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSum = new ArrayList<>();
        int sum = 0;
        helper(result, currSum, target, nums, sum, 0);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> currSum, int target, int[] nums, int sum, int start){
        if(sum > target) return;
        if(sum == target){
            result.add(new ArrayList<>(currSum));
            return;
        } else {
            for(int i = start; i < nums.length; i++){ // currSum{2,5,,}
                currSum.add(nums[i]);
                helper(result, currSum, target, nums, sum+nums[i], i);
                currSum.remove(currSum.size()-1);
            }
        }
    } 
}
