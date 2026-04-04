class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        // using 2 heaps
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
            // insert in left max heap
            leftMaxHeap.add(num);
        }
        else{
            // insert in right min heap
            rightMinHeap.add(num);
        }
        // always maintain leftMaxHeap's size should be 1 greater than rightMinHeap size.
        // or leftMaxHeap's size should equal rightMinHeap
        if(leftMaxHeap.size() - rightMinHeap.size() > 1){
            rightMinHeap.add(leftMaxHeap.poll());
        }
        else if (leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()){
            // even no. of elements present
            // find avg.
            return (1.0*(leftMaxHeap.peek()+rightMinHeap.peek()))/2.0;
        }
        else{
            // leftMaxHeap's top is the answer
            return leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
