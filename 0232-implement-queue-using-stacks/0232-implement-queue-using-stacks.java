class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!stack1.isEmpty()) {
            int cur = stack1.pop();
            stack2.push(cur);
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            int cur = stack2.pop();
            stack1.push(cur);
        }
    }
    
    public int pop() {
        if (stack1.isEmpty()) return -1;
        return stack1.pop();
    }
    
    public int peek() {
        if (stack1.isEmpty()) return -1;
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */