class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, target, curr, 0);
        return result;
    }

    private void helper(int[] nums, int target, List<Integer> curr, int i){
        if(target == 0){
            result.add(new ArrayList(curr));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        curr.add(nums[i]);
        helper(nums, target - nums[i], curr, i);
        curr.remove(curr.size() - 1);
        helper(nums, target, curr, i + 1);
    }
}
