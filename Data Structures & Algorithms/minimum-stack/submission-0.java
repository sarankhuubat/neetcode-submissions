class MinStack {
    Stack<Integer> minStack;
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty())
            minStack.pop();
    }
    
    public int top() {
        if(!minStack.isEmpty())
            return minStack.peek();
        
        return 0;
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = minStack.peek();

        while(!minStack.isEmpty()){
            min = Math.min(min, minStack.peek());
            tmp.push(minStack.pop());
        }

        while(!tmp.isEmpty()){
            minStack.push(tmp.pop());
        }

        return min;
    }
}
