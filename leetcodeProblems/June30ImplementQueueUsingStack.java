import java.util.Stack;
class Queue{
    // this approach is better when no. of push operations << no. of top and pop operations
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // SC : O(2*n)
    public void push(int x){
        // TC : O(2n)
        // push everything into stack2
        while(s1.size() >= 0){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(s2.size() >= 0){
            s1.push(s2.pop());
        }
    }
    public int top(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return s1.peek();
    }
    public int pop(){
        if(s1.isEmpty()){
            System.out.println("Stack overflow!");
            return -1;
        }
        return s1.pop();
    }
    public int size(){
        return s1.size();
    }
}

class QueueOptimized{
    // better when no. of push operations are more than pop and top operations
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int x){
        // O(1)
        s1.push(x);
    }
    public int pop(){
        // O(n) --> occasionally
        if(!s2.isEmpty()){
            return s2.pop();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    public int top(){
        // O(n)  --> occasionally
        if(!s2.isEmpty()){
            return s2.peek();
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
}
