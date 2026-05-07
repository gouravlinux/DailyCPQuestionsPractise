class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n^2)
        // SC : O(k) where k is max no. of non-duplicate characters in a subarray of s 
        int n = s.length();
        int len = 0;
        for(int i = 0;i < n;i++){
            Set<Character> set = new HashSet<>();
            for(int j = i;j < n;j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    break;//duplicate found
                }else{
                    len = Math.max(len, j-i+1);
                    set.add(ch);
                }
            }
        }
        return len;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n^2)
        // SC : O(256) -> O(1)
        int n = s.length();
        int len = 0;
        for(int i = 0;i < n;i++){
            boolean[] visited = new boolean[256];
            for(int j = i;j < n;j++){
                char ch = s.charAt(j);
                int val = ch;
                if(visited[val] == true){
                    break;//duplicate found
                }else{
                    len = Math.max(len, j-i+1);
                    visited[val] = true;
                }
            }
        }
        return len;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n)
        // SC : O(256) -> O(1)
        int n = s.length();
        int len = 0;
        int[] visited = new int[256];//stores idx
        Arrays.fill(visited, -1);
        int l = 0;
        for(int r = 0;r < n;r++){
            char ch = s.charAt(r);
            int idx = ch;
            if(visited[idx] != -1){
                // visited
                if(visited[idx] >= l){
                    // within substring
                    l = visited[idx]+1;
                }
            }
            len = Math.max(len, r-l+1);
            visited[idx] = r;
        }
        return len;
    }
}
