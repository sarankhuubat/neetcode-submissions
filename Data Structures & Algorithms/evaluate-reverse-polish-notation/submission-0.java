class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n = Integer.parseInt(stack.pop());
                int m = Integer.parseInt(stack.pop());
                if(s.equals("+"))
                    stack.push(String.valueOf(n + m));
                if(s.equals("-"))
                    stack.push(String.valueOf(m - n));
                if(s.equals("*"))
                    stack.push(String.valueOf(m * n));
                if(s.equals("/"))
                    stack.push(String.valueOf(m / n));
            } else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
