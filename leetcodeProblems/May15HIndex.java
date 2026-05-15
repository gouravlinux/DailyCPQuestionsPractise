class Solution {
    int n;
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(int[] arr){
        int i = 0;
        int j = n-1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public int hIndex(int[] citations) {
        // TC : O(nlogn)+O(n)+O(n)
        // SC : O(1)
        n = citations.length;
        // brute-force approach
        // sort the array in descending order
        Arrays.sort(citations);// for sorting
        reverse(citations);//for descending order
        int i = 0;
        while(i < n && citations[i] > i){
                // all papers from 0 to i are cited atleast (i+1) times
                // keep incrementing until citations[i] <= i
                i++;
        }
        return i; 
    }
}

class Solution {
    public int hIndex(int[] citations) {
        // optimal approach
        // TC : O(n)
        // SC : O(1)
        int n = citations.length;
        // take freq array storing which paper is cited i times 
        // why n+1 size? 
        // eg [100,4,4,4] could have 100 size freq array
        // but think like this, H-Index means max value of h such that 
        // atleast h papers have been cited atleast h times
        // that means 100 to be h-idx means atleast 100 papers must have
        // citations[i] = 100
        // that would not be possible any way
        int[] freq = new int[n + 1];
        for (int num : citations) {
            if (num >= n) {// if like 100, but size is only n+1
                freq[n]++;
            } else {
                freq[num]++; // other than smaller idx in freq
            }
        }
        int cnt = freq[n];
        int i = n;
        while(cnt < i){
            i--;
            cnt += freq[i];
        }
        // now cnt >= i which means there are cnt papers who as atleast i citations
        return i;
    }
}

