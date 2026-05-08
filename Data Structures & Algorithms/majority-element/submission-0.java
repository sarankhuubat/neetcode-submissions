class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, maxCount = 0;

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);

            if(map.get(n) > maxCount){
                res = n;
                maxCount = map.get(n);
            }
        }

        return res;
    }
}