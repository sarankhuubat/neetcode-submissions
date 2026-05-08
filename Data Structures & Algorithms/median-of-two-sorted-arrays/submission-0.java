class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int l = 0;
        int r = nums1.length;
        while(l <= r){
            int mid = l + (r-l) / 2;
            int mid2 = half - mid;

            int left1 = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int right1 = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                if(total % 2 != 0)
                    return Math.max(left1, left2);
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if(left1 > right2){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
} 
