class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0, r = 0;
        Set<Character> list = new HashSet<>();

        while(r < s.length()){
            while(list.contains(s.charAt(r))){
                list.remove(s.charAt(l));
                l++;
            }
            list.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
