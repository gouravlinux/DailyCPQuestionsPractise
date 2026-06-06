class Solution {
    public int minSetSize(int[] arr) {
        // TC : O(n)+O(klog(k)) where k is the no. of unique elements
        // SC : O(k)
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        for(int key: freqMap.keySet()){
            maxHeap.add(new int[]{key, freqMap.get(key)});
        }
        int elementsRemoved = 0;
        int ans = 0;
        while(!maxHeap.isEmpty()){
            ans++;
            int[] item = maxHeap.poll();
            elementsRemoved += item[1];
            if(elementsRemoved >= n/2){
                break;
            }
        }
        return ans;
    }
}
