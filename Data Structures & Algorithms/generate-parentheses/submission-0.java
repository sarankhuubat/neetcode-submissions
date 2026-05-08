class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> tmpStack = new Stack<>();
        List<String> result = new ArrayList<>();

        helper(tmpStack, result, n, 1, 1);

        return result;
    }

    public void helper(Stack<Character> tmpStack , List<String> res, int n,
                        int openPar, int closePar){
        if(tmpStack.size() == 2 * n){
            StringBuilder resultStr = new StringBuilder();
            for(char c : tmpStack){
                resultStr.append(c);
            }
            res.add(resultStr.toString());
            return;
        }

        if(openPar <= n){
            tmpStack.push('(');
            helper(tmpStack, res, n, openPar + 1, closePar);
            tmpStack.pop();
        }

        if(openPar > closePar && closePar <= n){
            tmpStack.push(')');
            helper(tmpStack, res, n, openPar, closePar + 1);
            tmpStack.pop();
        }
        
    }
}
