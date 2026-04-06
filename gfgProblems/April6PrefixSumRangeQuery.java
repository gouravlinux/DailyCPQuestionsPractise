class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        // code here
        // SC : O(n)
        // TC : O(n+q) where q is the no. of queries
        int n = arr.length;
        int[] prefix = new int[n+1];
        // compute prefix
        // prefix[i] = till index i-1 what is the sum?
        prefix[0] = 0;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += arr[i];
            prefix[i+1] = sum;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] query: queries){
            int l = query[0];
            int h = query[1];
            list.add(prefix[h+1]-prefix[l]);
        }
        return list;
    }
}
