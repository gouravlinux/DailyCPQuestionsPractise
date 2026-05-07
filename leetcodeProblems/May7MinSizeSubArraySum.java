class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        // TC : O(n)
        // SC : O(1)
        int start = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - start + 1);
                sum -= nums[start++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        // TC : O(nlogn)
        // SC : O(n)
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i = 1;i <= n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        for(int i = 0;i < n;i++){
            int targetVal = target + prefixSum[i];
            int j = Arrays.binarySearch(prefixSum, targetVal);
            //find index j 
            // using prefixSum[j] >= target + prefixSum[i]
            if(j < 0){
                j = -j-1;
            }
            if(j == n+1){// that would mean that targetVal is greater than all values in array, so no need to update minLen
                continue;
            }
            minLen = Math.min(minLen, j-i);
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
	// TC : O(n^2)
	// SC : O(1)
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
