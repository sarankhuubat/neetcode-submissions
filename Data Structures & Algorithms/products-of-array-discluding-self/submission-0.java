class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int[] result = new int[nums.length];
        result[0] = 1;

        for(int i = 0; i < nums.length - 1; i++){
            pre = pre * nums[i];
            result[i + 1] = pre;
        }

        int post = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] =  result[i] * post;
            post = post * nums[i];
        }

        return result;
    }
}  
