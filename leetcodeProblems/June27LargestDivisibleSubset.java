import java.util.*;
class Solution {
    List<Integer> res;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        /*
         * using tabulation
         * TC : O(n^2) + O(n)
         * SC : O(n)
         */
        int n = nums.length;
        res = new ArrayList<>();
        // lis code (tabulation approach) is modified for this question
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }
        // sort the array
        Arrays.sort(nums);

        int startIdx = 0;
        int maxLDS = 0; // longest divisible subsequence

        for (int i = 1; i < n; i++) {
            for (int prevIdx = i - 1; prevIdx >= 0; prevIdx--) {
                // since ith element > prevIdxth element, only check below first condition
                if (nums[i] % nums[prevIdx] == 0 && dp[i] <= dp[prevIdx] + 1) {
                    dp[i] = dp[prevIdx] + 1;
                    hash[i] = prevIdx;
                }
            }
            if (maxLDS < dp[i]) {
                maxLDS = dp[i];
                startIdx = i;
            }
        }

        // make the res list
        while (startIdx != hash[startIdx]) {
            res.add(nums[startIdx]);
            startIdx = hash[startIdx];
        }
        res.add(nums[startIdx]);

        Collections.reverse(res);
        return res;
    }
}