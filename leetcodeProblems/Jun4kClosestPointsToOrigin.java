class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // TC : O(n*log(k) + k)
        // SC : O(k)
        // max heap of size k
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int dist_a = a[0] * a[0] + a[1] * a[1];// dist^2 of 'a' point to (0,0)
            int dist_b = b[0] * b[0] + b[1] * b[1];// dist^2 of 'b' point to (0,0)
            return Integer.compare(dist_b, dist_a);
        });
        for(int[] point: points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.toArray(new int[k][]);
    }
}
