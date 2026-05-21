class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> list = new HashSet<>();
        int res = 0;
        int l = 0, r = 0;

        while(r < s.length()){
            while(list.contains(s.charAt(r))){
                list.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r - l +1);
            list.add(s.charAt(r));
            r++;
        }

        return res;
    }
}
