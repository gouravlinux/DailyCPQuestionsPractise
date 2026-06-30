class Stack {
    int top = -1;
    int[] stack = new int[10];

    /*
     * all operations take TC : O(1)
     * SC : O(10) as the array is not dynamic.
     */
    public void push(int x) {
        if (top >= 10) {
            System.out.println("Stack Overflow!");
            return;
        }
        top = top + 1;
        stack[top] = x;
    }

    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int item = stack[top];
        top = top - 1;
        return item;
    }

    public int size() {
        return top + 1;
    }
}

public class June29ImplementStackUsingArray {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(0);
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.push(5);
        System.out.println(st.top());
        System.out.println(st.size());
    }
}