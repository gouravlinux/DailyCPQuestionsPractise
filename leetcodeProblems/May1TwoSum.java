class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        int[] ans = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int x = target - nums[i];
            if(map.containsKey(x)){
                ans[0] = map.get(x).get(0);
                ans[1] = i; 
                break;
            }else{
                if(map.containsKey(nums[i])){
                    map.get(nums[i]).add(i);
                }else{
                    map.put(nums[i],new ArrayList<>());
                    map.get(nums[i]).add(i);
                }
            }
        }
        return ans;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TC : O(n^2)
        // SC : O(1)
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0;i < n;i++){
            int x = nums[i];
            for(int j = i+1;j < n;j++){
                int y = nums[j];
                if(x+y == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
