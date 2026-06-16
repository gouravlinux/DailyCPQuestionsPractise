public class Solution {
    public static int longestCommonSubsequence(String text1, String text2,int[][] dp) {
        int m = text1.length();
        int n = text2.length();
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
        // printing dp table to understand
        // for(int i = 0;i <= m;i++){
        //     for(int j = 0;j <= n;j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][0];
    }
    public static String findLCS(int m, int n, String s1, String s2){
        int[][] dp = new int[m+1][n+1];
        // first find the LCS value
        int lcsVal = longestCommonSubsequence(s1, s2, dp);
        // now, find out the LCS String
        int i = 0;
        int j = 0;
        StringBuilder res = new StringBuilder();

	// to understand code, just understand how dp table was filled
        while(i < m && j < n){
            // while both strings are not exhausted
            if(s1.charAt(i) == s2.charAt(j)){
                res.append(s1.charAt(i));
                i = i+1;
                j = j+1;
            }

            else if(dp[i+1][j] > dp[i][j+1]){
                i = i+1;
            }else{
                // if dp[i+1][j] <= dp[i][j+1]
                // if dp[i+1][j] == dp[i][j+1], will get 2 LCS, don't worry, go anywhere
                j = j+1;
            }
        }
        return res.toString();
    }
}
