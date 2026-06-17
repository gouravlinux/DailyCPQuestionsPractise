class Solution {
    int m;
    int n;
    int ans;
    private int solve(int i,int j,int[] s1, int[] s2){
        if(i >= m || j >= n){
            return 0;
        }
        
        // not matching
        if(s1[i] != s2[j]){
            return 0; // as they are not matching
        }
        
        // else they are matching: s1[i] == s2[j]
        int matchAns = 1 + solve(i+1, j+1, s1, s2); // see for next guys in both strings
        ans = Math.max(ans, matchAns);
        return matchAns;
    }
    public int findLength(int[] s1, int[] s2) {
        /*
            using recursion 
            TC : O(m*n*min(m,n))
            SC : O(min(m,n)) (recursion depth)
        */
        m = s1.length;
        n = s2.length;
        ans = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(s1[i] == s2[j]){
                    solve(i,j,s1,s2);
                }
            }
        }
        return ans;
    }
}

class Solution {
    int m;
    int n;
    int ans;
    int[][] dp;
    private int solve(int i,int j,int[] s1,int[] s2){
        if(i >= m || j >= n){
            return 0;
        }
        
        // not matching
        if(s1[i] != s2[j]){
            return dp[i][j] = 0; // as they are not matching
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // else they are matching: s1[i] == s2[j]
        int matchAns = 1 + solve(i+1, j+1, s1, s2); // see for next guys in both strings
        ans = Math.max(ans, matchAns);
        return dp[i][j] = matchAns;
    }
    public int findLength(int[] s1, int[] s2) {
        /*
            using recursion + memoization
            TC : O(m*n)
            SC : O(m*n) + O(min(m,n)) (recursion depth)
        */
        m = s1.length;
        n = s2.length;
        ans = 0;
        dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(s1[i] == s2[j]){
                    solve(i,j,s1,s2);
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int findLength(int[] s1, int[] s2) {
        /*
            using tabulation
            TC : O(m*n)
            SC : O(m*n)
        */
        
        int m = s1.length;
        int n = s2.length;
        
        int ans = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = m;i >= 0;i--){
            for(int j = n;j >= 0;j--){
                if(i == m || j == n){
                    dp[i][j] = 0; // out-of-bounds
                }else if(s1[i] == s2[j]){
                    // matching character
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    // not matching
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}

class Solution {
    public int findLength(int[] s1, int[] s2) {
        /*
            using tabulation + space-optimization
            TC : O(m*n)
            SC : O(n)
        */
        
        int m = s1.length;
        int n = s2.length;
        
        int ans = 0;
        
        int[] next = new int[n+1];
        
        for(int i = m;i >= 0;i--){
            int[] curr = new int[n+1];
            for(int j = n;j >= 0;j--){
                if(i == m || j == n){
                    curr[j] = 0; // out-of-bounds
                }else if(s1[i] == s2[j]){
                    // matching character
                    curr[j] = 1 + next[j+1];
                }else{
                    // not matching
                    curr[j] = 0;
                }
                ans = Math.max(ans, curr[j]);
            }
            next = curr;
        }
        return ans;
    }
}
