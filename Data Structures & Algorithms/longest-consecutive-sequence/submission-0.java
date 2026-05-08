class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int i : nums)
            set.add(i);

        for(int i : nums){
            int curr = 0;
            while(set.contains(i)){
                curr++;
                i++;
            }

            res = Math.max(curr, res);
        }

        return res;
    }
}
