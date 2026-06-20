class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {

        /*
            TC : O(m*n) + O(max(m,n)) + O(max(m,n) - min(m,n))
            SC : O(m*n) + O(m+n-len(LCS)) for storing res
        */
        // LCS code 
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // filling the dp table
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // if str1.charAt(i) != str2.charAt(j)
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // now using DP table, build the Shortest Common SuperSequence
        StringBuilder res = new StringBuilder();

        int i = 0;
        int j = 0;

    
        // similar to logic of merge sorting
        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                res.append(s1.charAt(i)); // only add once if same
                i++;
                j++;
            } else if (dp[i][j + 1] > dp[i + 1][j]) {
                // then I came from dp[i][j+1]
                // append jth character of s2 first, and then move to dp[i][j+1]
                res.append(s2.charAt(j));
                j = j + 1;
            } else {
                // I would have came from dp[i+1][j]
                // append ith character of s1 first, and then move to dp[i+1][j]
                res.append(s1.charAt(i));
                i = i + 1;
            }
        }

        while(i < m){
            // if i is not exhausted, append ith character and move to i+1
            res.append(s1.charAt(i));
            i = i + 1;
        }
        
        while(j < n){
            // if j is not exhaunsted, append jth character and move to j+1
            res.append(s2.charAt(j));
            j = j + 1;
        }

        return res.toString();
    }
}