class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();

        helper(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int i, int target, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i >= nums.length)
            return;

        curr.add(nums[i]);
        helper(nums, i, target - nums[i], curr);
        curr.remove(curr.size() - 1);
        helper(nums, i + 1, target, curr);
        
    }
}
