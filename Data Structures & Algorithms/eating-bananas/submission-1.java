class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max, i);
        }

        int l = 1, r = max, res = max;
        while(l <= r){
            int mid = l + (r - l)/2;
            int curH = 0;
            for(int i : piles){
                curH += Math.ceil((double) i/mid);
            }

            if(curH > h)
                l = mid +1;
            else if(curH <= h) {
                r = mid - 1;
                res = mid;
            }
        }

        return res;
    }
}
// 1 per h
//[1,4,3,2] = 10

// 2 per h
//[1,4,3,2] = 1, 2, 2, 1 = 6

// 3 per h
//[1,4,3,2] = 1, 2, 1, 1 = 5

// 4 per h
//[1,4,3,2] = 4
