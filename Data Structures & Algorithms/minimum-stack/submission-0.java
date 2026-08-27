class MinStack {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minQ = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        minQ.push(Math.min(val, minQ.isEmpty()? Integer.MAX_VALUE : minQ.peek()));
    }
    
    public void pop() {
        stack.pop();
        minQ.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minQ.peek();
    }
}
