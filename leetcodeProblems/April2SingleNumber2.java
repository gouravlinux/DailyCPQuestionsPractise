class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int k = 0;k < 32;k++){//for all 32 positions in int
            int noOfZeroes = 0;
            int noOfOnes = 0;
            for(int num: nums){
                if((num & (1 << k)) != 0){
                    noOfOnes++;
                }
                else{
                    noOfZeroes++;
                }
            }
            if(noOfZeroes%3 == 0){
                // means that at ith position of 32-bit int 1 should be present
                ans = (ans | (1 << k));
            }
            else{
                // means that at ith position of 32-bit int 0 should be present
                ans = (ans | (0 << k));
            }
        }
        return ans;
    }
}
