class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int n : nums){
            set.add(n);
        }

        for(int i = 0; i < nums.length; i++){
            int len = 1;
            while(set.contains(nums[i] + len)){
                len++;
            }

            res = Math.max(res, len);
            //set.add(nums[i]);
        }

        return res;
    }
}
