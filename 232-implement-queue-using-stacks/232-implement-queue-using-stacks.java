class MyQueue {
    Stack<Integer> mainStack, temp;

    public MyQueue() {
        mainStack = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        while(!mainStack.isEmpty()){
            temp.push(mainStack.pop());
        }
        mainStack.push(x);
        while(!temp.isEmpty()){
            mainStack.push(temp.pop());
        }
    }
    
    public int pop() {
        return mainStack.pop();
    }
    
    public int peek() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
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