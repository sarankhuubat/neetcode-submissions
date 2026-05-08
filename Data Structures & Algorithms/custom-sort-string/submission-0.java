class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for(char c : order.toCharArray()){
            int i = c - 'a';
            while(count[i] > 0){
                res.append(c);
                count[i]--;
            }
        }

        for(int i = 0; i < 26; i++){
            char c = (char) ('a' + i);
            while(count[i] > 0){
                res.append(c);
                count[i]--;
            }
        }

        return res.toString();
    }
}