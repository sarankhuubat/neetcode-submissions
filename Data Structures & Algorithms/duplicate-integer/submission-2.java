class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            if(list.contains(i)){
                return true;
            }
            list.add(i);
        }

        return false;
    }
}