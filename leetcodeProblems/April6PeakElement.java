class Solution {
    public int findPeakElement(int[] nums) {
	// TC : O(log n) and SC : O(1)
        int n = nums.length;
        // edge conditions
        if(n == 1){
            // only one element: it is a peak
            return 0;
        }
        if(nums[0] > nums[1]){
            // first element is the peak
            return 0;
        }
        if(nums[n-1] > nums[n-2]){
            // last element is the peak
            return n-1;
        }
        int l = 1;
        int h = n-2;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                // peak element
                return mid;
            }
            if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                // on increasing slope
                l = mid+1;
            }
            else if (nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){
                // on decreasing slope
                h = mid-1;
            }
            else if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                // valley mid
                // go to either left half or right half
                h = mid-1;
            }
        }
        return -1;
    }
}
