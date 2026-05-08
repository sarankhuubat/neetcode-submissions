class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n = stack.pop();
                int m = stack.pop();
                if(s.equals("+"))
                    stack.push(n + m);
                if(s.equals("-"))
                    stack.push(m - n);
                if(s.equals("*"))
                    stack.push(m * n);
                if(s.equals("/"))
                    stack.push(m / n);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
