class Solution {
    int m, n;

    private int solve(int i, int j, String text1, String text2) {
        if (i >= m || j >= n) {
            return 0; // out-of-bounds
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            // same character!
            return 1 + solve(i + 1, j + 1, text1, text2);
        }

        return Math.max(solve(i, j + 1, text1, text2), solve(i + 1, j, text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        /*
            using recursion
            TC : O(2^(m+n))
            SC : O(m+n)
        */
        m = text1.length();
        n = text2.length();
        return solve(0, 0, text1, text2);
    }
}

class Solution {
    int m, n;
    int[][] dp;
    private int solve(int i, int j, String text1, String text2) {
        if (i >= m || j >= n) {
            return 0; // out-of-bounds
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            // same character!
            return dp[i][j] = 1 + solve(i + 1, j + 1, text1, text2);
        }

        return dp[i][j] = Math.max(solve(i, j + 1, text1, text2), solve(i + 1, j, text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        /*
            using recursion + memoization
            TC : O(m*n)
            SC : O(m*n) + O(max(m,n)) stack space
        */
        m = text1.length();
        n = text2.length();
        dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, text1, text2);
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            using tabulation
            TC : O(m*n)
            SC : O(m*n)
        */
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = 0; // out-of-bounds
                } else if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            using tabulation + space-optimization to 2 1D array
            TC : O(m*n)
            SC : O(n)
        */
        int m = text1.length();
        int n = text2.length();
        int[] next = new int[n + 1];
        for (int i = m; i >= 0; i--) {
            int[] curr = new int[n + 1];
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    curr[j] = 0; // out-of-bounds
                } else if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + next[j + 1];
                } else {
                    curr[j] = Math.max(next[j], curr[j + 1]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}
