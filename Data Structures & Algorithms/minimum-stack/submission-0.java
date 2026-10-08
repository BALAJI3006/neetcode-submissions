class MinStack {
    Stack<Integer> min;
    Stack<Integer> s = new Stack<>();
    public MinStack() {
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(!min.isEmpty() && min.peek()>=val){
            min.push(val);
        }
        if(min.isEmpty()){
            min.push(val);
        }
    }
    
    public void pop() {
        int val = s.pop();
        if(!min.isEmpty() && val==min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(!min.isEmpty())
            return min.peek();
        else
            return 0;
    }
}
