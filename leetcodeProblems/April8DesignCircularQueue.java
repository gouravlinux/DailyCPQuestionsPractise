class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int n;// max size
    int currSize;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = -1;
        n = k;
        currSize = 0;
    }
    
    public boolean enQueue(int value) {
        // if queue is full
        if(isFull()){
            return false;
        }
        rear = (rear+1)%n;
        arr[rear] = value;
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        // check if queue is empty
        if(isEmpty()){
            return false;
        }
        front = (front+1)%n;
        currSize--;
        return true;
    }
    
    public int Front() {
        // if queue empty
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
        // if queue empty
        if(isEmpty()) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(currSize == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(currSize == n){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
