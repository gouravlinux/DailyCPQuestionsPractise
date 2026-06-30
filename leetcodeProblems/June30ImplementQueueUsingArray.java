class Queue {
    int size = 10;
    int[] que = new int[size];
    int front = -1;
    int end = -1;
    int currSize = 0;

    /*
     * TC of all operations is O(1)
     * SC : O(size)
     */
    public void push(int x) {
        if (currSize == size) {
            System.out.println("Queue Overflow!");
        }
        if (currSize == 0) {
            front = end = 0;
        } else {
            end = (end + 1) % size;
        }
        que[end] = x;
        currSize++;
    }

    public int pop() {
        if (currSize == 0) {
            System.out.println("Queue Underflow!");
        }
        int item = que[front];
        if (currSize == 1) {
            front = end = -1;
        } else {
            front = (front + 1) % size;
        }
        currSize--;
        return item;
    }

    public int top() {
        if (currSize == 0) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return que[front];
    }

    public int size() {
        return currSize;
    }
}

public class June30ImplementQueueUsingArray {
    public static void main(String[] args) {
        Queue queObj = new Queue();
        queObj.push(5);
        System.out.println(queObj.pop());
        queObj.push(6);
        System.out.println(queObj.size());
        System.out.println(queObj.top());
    }

}