class Solution {
    int n;
    private int solve(int i,int remWt,int[] val,int[] wt){
        
        if(remWt < 0){
            return Integer.MIN_VALUE; // profit not possible
        }
        
        if(remWt == 0 || i == n){
            return 0; // return as this is the end
        }
        
        int take = val[i] + solve(i, remWt - wt[i], val, wt);
        int not_take = 0 + solve(i+1, remWt, val, wt);
        return Math.max(take, not_take);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        /*
            I have infinite supply of each item, and I can take any item multiple times
            using simple recursion
            TC : exponential
            SC : O(capacity) stack space => capacity
        */
        n = val.length;
        return solve(0, capacity, val, wt);
    }
}

class Solution {
    int n;
    int[][] dp;
    private int solve(int i,int remWt,int[] val,int[] wt){
        
        if(remWt < 0){
            return Integer.MIN_VALUE; // profit not possible
        }
        
        if(remWt == 0 || i == n){
            return 0; // return as this is the end
        }
        
        if(dp[i][remWt] != -1)
            return dp[i][remWt];
        
        int take = val[i] + solve(i, remWt - wt[i], val, wt);
        int not_take = 0 + solve(i+1, remWt, val, wt);
        return dp[i][remWt] = Math.max(take, not_take);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        /*
            I have infinite supply of each item, and I can take any item multiple times
            using recursion + memoization
            TC : O(n * capacity)
            SC : O(n * capacity) + O(capacity) stack space
        */
        n = val.length;
        dp = new int[n + 1][capacity + 1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, capacity, val, wt);
    }
}

class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		/*
			tabulation
			TC : O(n * capacity)
			SC : O(n * capacity)
		*/
		
		int n = val.length;
		
		int[][] dp = new int[n + 1][capacity + 1];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int remWt = 0; remWt <= capacity; remWt++) {
				if (remWt == 0 || i == n) {
					dp[i][remWt] = 0;
				} else {
					int take = (remWt - wt[i] < 0)? Integer.MIN_VALUE : val[i] + dp[i][remWt - wt[i]];
					int notTake = 0 + dp[i + 1][remWt];
					dp[i][remWt] = Math.max(take, notTake);
				}
			}
		}
		
		return dp[0][capacity];
		
	}
}

class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		/*
			tabulation
			TC : O(n * capacity)
			SC : O(capacity)
		*/
		
		int n = val.length;
		
		int[] next = new int[capacity + 1];
		
		for (int i = n - 1; i >= 0; i--) {
		    int[] curr = new int[capacity + 1];
			for (int remWt = 0; remWt <= capacity; remWt++) {
				if (remWt == 0 || i == n) {
					curr[remWt] = 0;
				} else {
					int take = (remWt - wt[i] < 0)? Integer.MIN_VALUE : val[i] + curr[remWt - wt[i]];
					int notTake = 0 + next[remWt];
					curr[remWt] = Math.max(take, notTake);
				}
			}
			next = curr;
		}
		
		return next[capacity];
		
	}
}

