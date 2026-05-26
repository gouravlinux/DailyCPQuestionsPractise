class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // TC : O(n+g+k) where g is the no. of unique elements in array
        // SC : O(g+g) = O(g) 
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int key: freqMap.keySet()){
            int val = freqMap.get(key);
            maxHeap.add(new int[]{key,val});
        }
        int[] res = new int[k];
        int i = 0;
        while(k-- > 0){
            res[i++] = maxHeap.poll()[0];
        }
        return res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // TC : O(n+g+k) where g is the no. of unique elements in array
        // SC : O(g+k) 
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        for(int key: freqMap.keySet()){
            int val = freqMap.get(key);
            minHeap.add(new int[]{key,val});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(k-- > 0){
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
