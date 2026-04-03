class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        // use maxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);//min-heap
        // TC : O(m * n)
        // SC : O(k)
        int cnt = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k){
                    //need to add
                    pq.add(new int[]{sum, i, j});
                }
                else if (pq.peek()[0] > sum){
                    // remove top element
                    pq.poll();
                    // add new 
                    pq.add(new int[]{sum, i, j});
                }
                else{
                    break;// as all other j indices will have greater sum
                }
            }
        }
        List<List<Integer>> ls = new ArrayList<>();
        while(k-- > 0){
            int[] arr = pq.poll();
            ls.add(Arrays.asList(nums1[arr[1]], nums2[arr[2]]));
        }
        return ls;
    }
}
class Solution {
    int m;
    int n;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        m = nums1.length;
        n = nums2.length;
        // use minHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> visited = new HashSet<>();
        int sum = nums1[0] + nums2[0];
        pq.add(new int[] { sum, 0, 0 });
        visited.add(0 + "," + 0);
        List<List<Integer>> ls = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) { // O(k * log(size of heap)) or 
					   // O(k * log(min(m*n, k))
            int[] item = pq.poll();
            int i = item[1];
            int j = item[2];
            ls.add(Arrays.asList(nums1[i], nums2[j]));
            // push (i+1, j) if is possible
            String temp = Integer.toString(i + 1) + "," + j;
            if (i + 1 < m && !visited.contains(temp)) {
                visited.add(temp);
                sum = nums1[i + 1] + nums2[j];
                pq.add(new int[] { sum, i + 1, j });
            }
            temp = i + "," + Integer.toString(j + 1);
            // push (i, j+1) if is possible
            if (j + 1 < n && !visited.contains(temp)) {
                visited.add(temp);
                sum = nums1[i] + nums2[j + 1];
                pq.add(new int[] { sum, i, j + 1 });
            }
        }
        return ls;
    }
}
