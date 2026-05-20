class Solution {
    private void reverse(char[] arr,int i,int j){
        if(i >= j) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        reverse(arr, i, j);
    }
    public String reverseWords(String s) {
        // TC : O(n)
        // SC : O(1) (except string array and string output)
        int n = s.length();
        char[] arr = s.toCharArray();
        reverse(arr, 0, n-1); // reverse the entire char. array
        // clean spaces and reverse individual words in-place
        int writeIdx = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] != ' '){
                // append a space before subsequent words
                if(writeIdx > 0) arr[writeIdx++] = ' ';
                int wordStart = writeIdx;
                // copy the word to its new cleaned position
                while(i < n && arr[i] != ' ')
                    arr[writeIdx++] = arr[i++];
                
                // reverse the single word back to normal
                reverse(arr, wordStart, writeIdx-1);
            }
        }
        return new String(arr, 0, writeIdx);
    }
}

class Solution {
    private void swap(String[] arr,int i,int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }
    private void reverse(String[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        // O(N) time and space complexity
        s = s.trim();
        String[] arr = s.split("\\s+");
        reverse(arr);
        String result = String.join(" ", arr);
        return result;
    }
}
