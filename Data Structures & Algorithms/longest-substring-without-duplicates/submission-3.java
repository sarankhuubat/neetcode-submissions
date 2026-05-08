class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> list = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;

        while(r < s.length()){
            while(list.contains(s.charAt(r))){
                list.remove(s.charAt(l));
                l++;
            }
            list.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
