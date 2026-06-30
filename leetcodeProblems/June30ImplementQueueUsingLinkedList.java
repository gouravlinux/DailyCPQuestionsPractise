class Queue{
    Node front = null, rear = null;
    int currSize = 0;
    /*
        All operations 
        SC : O(1)
        TC : O(1)
    */
    public void push(int x){
        Node temp = new Node(x);
        if(front == null){
            front = rear = temp;
        }else{
            rear.next = temp;
        }
        currSize++;
    }
    public int pop(){
        if(currSize == 0){
            System.out.println("Queue Underflow!");
            return -1;
        }
        int item = front.value;
        front = front.next;
        currSize--;
        return item;
    }
    public int top(){
        if(front == null){
            System.out.println("Queue is Empty!");
            return -1;
        }
        return front.value;
    }
    public int size(){
        return currSize;
    }
}
public class June30ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        Queue que = new Queue();
        que.push(1);
        System.out.println(que.pop());
        System.out.println(que.pop());
        que.push(5);
        System.out.println(que.top());
        System.out.println(que.size());
    }
}
