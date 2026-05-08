public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr,
                           int openCnt, int closeCnt, int n) {

        // Base case: length == 2 * n
        if (curr.length() == 2 * n) {
            res.add(curr.toString());
            return;
        }

        // Add "(" if we still can
        if (openCnt < n) {
            curr.append('(');
            backtrack(res, curr, openCnt + 1, closeCnt, n);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }

        // Add ")" if valid
        if (closeCnt < openCnt) {
            curr.append(')');
            backtrack(res, curr, openCnt, closeCnt + 1, n);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }
}
