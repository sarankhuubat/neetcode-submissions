class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, curr);

        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr){
        if(i >= nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i + 1, curr);
        curr.remove(curr.size() - 1);

        while(i < nums.length - 1 && nums[i] == nums[i + 1]){
            i++;
        }

        dfs(nums, i + 1, curr);
    }
}
