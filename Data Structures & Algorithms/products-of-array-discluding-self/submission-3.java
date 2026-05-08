class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int cntZero = 0;
        int prod = 1;

        for(int n : nums){
            if(n != 0)
                prod *= n;
            if(n == 0)
                cntZero++;
        }

        if(cntZero > 1)
            return res;
        
        System.out.println(prod);
        for(int i = 0; i < len; i ++){
            if(cntZero > 0)
                res[i] = (nums[i] == 0) ? prod : 0;
            else
                res[i] = prod/nums[i];
        }

        return res;
    }
}  
