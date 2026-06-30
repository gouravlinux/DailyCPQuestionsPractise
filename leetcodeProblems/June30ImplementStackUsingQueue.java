import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueue {
    Queue<Integer> que = new LinkedList<>();

    public void push(int x) {
        // TC : O(n) where n is no. of elements already present
        int size = que.size();
        que.add(x);
        for (int i = 1; i <= size; i++) {
            que.add(que.poll());
        }
        return;
    }

    public int pop() {
        // TC : O(1)
        return que.poll();
    }

    public int top() {
        // TC : O(1)
        if(que.peek() == null)
            return -1;
        return que.peek();
    }
}

public class June30ImplementStackUsingQueue {
    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}