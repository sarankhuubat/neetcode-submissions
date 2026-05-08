class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] cache = new int[n][m]; 
        for(int[] i : cache){
            Arrays.fill(i, -1);
        }
        return dfs(text1, text2, 0, 0, cache);
    }

    private int dfs(String s1, String s2, int i, int j, int[][] cache){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        if(cache[i][j] != -1) return cache[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            cache[i][j] =  1 + dfs(s1, s2, i + 1, j + 1, cache);
        } else {
            cache[i][j] = Math.max(dfs(s1, s2, i + 1, j, cache), dfs(s1, s2, i, j + 1, cache));
        }

        return cache[i][j];
    }
}
