class Solution {
    int n;
    private int solve(int day,int prevDayActivity,int[][] mat){
        if(day >= n) 
            return 0;
        int ans = 0;
        for(int activity = 0;activity < 3;activity++){
            if(activity != prevDayActivity){
                ans = Math.max(ans, mat[day][activity] + solve(day+1, activity, mat));
            }
        }
        return ans;
    }
    public int maximumPoints(int mat[][]) {
        // using simple recursion
	// TC : O(3^n)
	// SC : O(n)
        n = mat.length;
        int ans = 0;
        // try out all possibilities
        return solve(0, -1, mat);
    }
}

class Solution {
    int n;
    int[][] dp;
    private int solve(int day,int prevDayActivity,int[][] mat){
        if(day >= n) 
            return 0;
        if(prevDayActivity != -1 && dp[day][prevDayActivity] != -1) 
            return dp[day][prevDayActivity];
        int ans = 0;
        for(int activity = 0;activity < 3;activity++){
            if(activity != prevDayActivity){
                ans = Math.max(ans, mat[day][activity] + solve(day+1, activity, mat));
            }
        }
        if(prevDayActivity != -1) 
            dp[day][prevDayActivity] = ans;
        return ans;
    }
    public int maximumPoints(int mat[][]) {
        // using recursion + memoization
        // TC : O(3*3*n) = T(9*n)
        // SC : O(3*n)(auxilary space)+O(n)(recursion stack space)
        n = mat.length;
        dp = new int[n][3];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans = 0;
        // try out all possibilities
        return solve(0, -1, mat);
    }
}

class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        // using tabulation 
        // TC : O(n*4*3) = O(12*n)
        // SC : O(4*(n+1))
        // the 3rd index activity is not an activity: represents state of having no previous activity
        int[][] dp = new int[n+1][4]; 
        for(int activity = 0;activity < 4;activity++){
            dp[n][activity] = 0;//after last day, no points
        }
        // dp[day][activity] = from day 'day' to day n, 
        // max points I can gain, when I am doing on day,
        // activity
        
        for(int day = n-1;day >= 0;day--){
            for(int prevActivity = 0;prevActivity < 4;prevActivity++){
                for(int activity = 0;activity < 3;activity++){
                    if(activity != prevActivity){
                        dp[day][prevActivity] = Math.max(dp[day][prevActivity], mat[day][activity]+dp[day+1][activity]);
                    }
                }
            }
        }
        
        return dp[0][3]; //result starting at day 0 with no previous activity (idx 3)
    }
}

class Solution {
    public int maximumPoints(int mat[][]) {
	// TC : O(3)+O(n*3*3)+O(3) ~ O(n)
	// SC : O(3*(n+1))
        int n = mat.length;
        // using tabulation 
        int[][] dp = new int[n+1][3];
        for(int activity = 0;activity < 3;activity++){
            dp[n][activity] = 0;//after last day, no points
        }
        // dp[day][activity] = from day 'day' to day n, 
        // max points I can gain, when I am doing on day,
        // activity
        
        for(int day = n-1;day >= 0;day--){
            for(int prevActivity = 0;prevActivity < 3;prevActivity++){
                for(int activity = 0;activity < 3;activity++){
                    if(activity != prevActivity){
                        dp[day][prevActivity] = Math.max(dp[day][prevActivity], mat[day][activity]+dp[day+1][activity]);
                    }
                }
            }
        }
        int ans = 0;
        // the answer is max. of all activities from day 0 to n-1
        for(int activity = 0;activity < 3;activity++){
            ans = Math.max(ans, dp[0][activity]);
        }
        return ans;
    }
}

class Solution {
	public int maximumPoints(int mat[][]) {
		int n = mat.length;
		// using tabulation + space optimization
		// TC : O(n*4*3) = O(12*n) ~ O(n)
		// SC : O(8) = O(1)
		// the 3rd index activity is not an activity: represents state of having no previous activity
		int[] prev = new int[4];
		int[] curr = new int[4];
		for (int activity = 0; activity < 4; activity++) {
			curr[activity] = 0; // after last day, no points
		}
		// dp[day][activity] = from day 'day' to day n,
		// max points I can gain, when I am doing on day,
		// activity
		
		for (int day = n - 1; day >= 0; day--) {
			for (int prevActivity = 0; prevActivity < 4; prevActivity++) {
				for (int activity = 0; activity < 3; activity++) {
					if (activity != prevActivity) {
						prev[prevActivity] = Math.max(prev[prevActivity], mat[day][activity]+curr[activity]);
					}
				}
				
			}
            curr = prev.clone();
		}
		
		return prev[3]; // result starting at day 0 with no previous activity (idx 3)
	}
}

