class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, int idx, List<Integer> curr){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || idx >= nums.length){
            return;
        }

        curr.add(nums[idx]);
        dfs(nums, target - nums[idx], idx, curr);
        curr.remove(curr.size() - 1);
        dfs(nums, target, idx + 1, curr);
    }
}
