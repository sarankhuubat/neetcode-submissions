class Solution {
    private String[] digitToChars = {
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        helper(0, "", digits);

        return res;
    }

    private void helper(int i, String curr, String digits){
        if(curr.length() == digits.length()){
            res.add(curr);
            return;
        }

        String chars = digitToChars[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            helper(i + 1, curr + c, digits);
        }
    }
}
