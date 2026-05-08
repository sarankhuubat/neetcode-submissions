class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(result, nums, cur);

        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, 
        List<Integer> cur){
        if(cur.size() == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        } else {
            for(int i : nums){
                if(!cur.contains(i)){
                    cur.add(i);
                    helper(result, nums, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
