class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')){
                    if((stack.peek() == '(' && s.charAt(i) == ')') ||
                            (stack.peek() == '[' && s.charAt(i) == ']') ||
                            (stack.peek() == '{' && s.charAt(i) == '}'))
                            stack.pop();
                    else 
                        return false;
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
