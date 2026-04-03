class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxAns = Integer.MIN_VALUE;
        // TC : O(n^2) , SC : O(1)
        for(int i = 0;i < n;i++){
            int prod = 1;
            for(int j = i;j < n;j++){
                prod *= nums[j];
                maxAns = Math.max(prod, maxAns);
            }
        }
        return maxAns;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        // TC : O(n) and SC : O(1)
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i = 0;i < n;i++){
            // either prefix product would be ans or suffix product
            if(prefix == 0){
                // restart prefix
                prefix = 1;// as 0 will make prod 0
            }
            if (suffix == 0){
                // restart suffix 
                suffix = 1;// as 0 will make prod 0
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
    }
}
