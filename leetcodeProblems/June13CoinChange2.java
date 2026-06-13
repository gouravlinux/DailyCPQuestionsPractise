class Solution {
    int n;
    private int solve(int i,int amt,int[] coins){
        if(amt == 0){
            // found a valid combination
            return 1;
        }
        if(i == n || amt < 0){
            return 0; // not a valid combination now
        }
        // if I take the ith coin
        int take_i = solve(i, amt-coins[i], coins);
        // if I not take that ith coin
        int not_take_i = solve(i+1, amt, coins);
        return take_i + not_take_i;
    }
    public int change(int amount, int[] coins) {
        /*
            using recursion
            TC : exponential
            SC > O(n)
        */
        n = coins.length;
        return solve(0, amount, coins);
    }
}

class Solution {
    int n;
    int[][] dp;
    private int solve(int i,int amt,int[] coins){
        if(amt == 0){
            // found a valid combination
            return 1;
        }
        if(i == n || amt < 0){
            return 0; // not a valid combination now
        }
        if(dp[i][amt] != -1)
            return dp[i][amt];
        // if I take the ith coin
        int take_i = solve(i, amt-coins[i], coins);
        // if I not take that ith coin
        int not_take_i = solve(i+1, amt, coins);
        return dp[i][amt] = take_i + not_take_i;
    }
    public int change(int amount, int[] coins) {
        /*
            using recursion + memoization
            TC : O(n * amount)
            SC : O(n * amount)
        */
        n = coins.length;
        dp = new int[n][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, amount, coins);
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        /*
            using tabulation
            TC : O(n*amount)
            SC : O(n*amount)
        */
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = n; i >= 0; i--) {
            for (int amt = 0; amt <= amount; amt++) {
                if (amt == 0) {
                    dp[i][amt] = 1;
                } else if (i == n) {
                    dp[i][amt] = 0;
                } else {
                    int take_i = (amt - coins[i] < 0) ? 0 : dp[i][amt - coins[i]];
                    int not_take_i = dp[i + 1][amt];
                    dp[i][amt] = take_i + not_take_i;
                }
            }
        }
        return dp[0][amount];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        /*
            using tabulation + space-optimization
            TC : O(n*amount)
            SC : O(amount)
        */
        int n = coins.length;
        int[] next = new int[amount + 1];
        for (int i = n; i >= 0; i--) {
            int[] curr = new int[amount+1];
            for (int amt = 0; amt <= amount; amt++) {
                if (amt == 0) {
                    curr[amt] = 1;
                } else if (i == n) {
                    curr[amt] = 0;
                } else {
                    int take_i = (amt - coins[i] < 0) ? 0 : curr[amt - coins[i]];
                    int not_take_i = next[amt];
                    curr[amt] = take_i + not_take_i;
                }
            }
            next = curr;
        }
        return next[amount];
    }
}
