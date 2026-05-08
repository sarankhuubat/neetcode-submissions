class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++){
            int cnt = 0;
            int j = i;
            while(j > 0){
                if((j & 1) == 1){
                    cnt++;
                }
                j = j>>1;
            }
            res[i] = cnt;
        }

        return res;
    }
}
