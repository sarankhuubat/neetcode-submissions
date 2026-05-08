class Solution {
    int[] cache;
    public int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return helper(s, 0);
    }

    private int helper(String s, int i){
        if(i == s.length())
            return 1;

        if(s.charAt(i) == '0')
            return 0;

        if(cache[i] != -1)
            return cache[i];

        int res = helper(s, i + 1);
        if(i < s.length() - 1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                res += helper(s, i + 2);
        }

        cache[i] = res;
        return cache[i];
    }
}
