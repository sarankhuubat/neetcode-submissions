class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(s.equals("-")){
                int n = stack.pop();
                int m = stack.pop();

                stack.push(m - n);
            } else if(s.equals("/")){
                int n = stack.pop();
                int m = stack.pop();

                stack.push(m/n);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
