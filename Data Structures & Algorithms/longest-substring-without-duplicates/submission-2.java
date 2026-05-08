class Solution {
    public int lengthOfLongestSubstring(String s) {
int left = 0, right = 0, max = 0; Set<Character> set = new HashSet<>(); while(right < s.length()){ while(set.contains(s.charAt(right))){ set.remove(s.charAt(left)); left++; } set.add(s.charAt(right)); max = Math.max(max, set.size()); right++; } return max;
    }
}
