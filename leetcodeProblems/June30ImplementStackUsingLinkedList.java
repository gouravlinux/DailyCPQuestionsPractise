class Node {
    // singly linked list
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
        this.value = -1;
    }
}

class Stack {
    Node top = null;
    int currSize = 0;
    /*
        TC : O(1)
        SC : O(1) 
        for all operations
    */
    public void push(int x) {
        currSize++;
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int item = top.value;
        top = top.next;
        currSize--;
        return item;
    }

    public int top() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.value;
    }

    public int size() {
        return currSize;
    }
}

public class June30ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.push(7);
        System.out.println(stack.size());
    }
}
