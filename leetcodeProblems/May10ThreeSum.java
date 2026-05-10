class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC : O(nlogn)+O(n*n)
        // SC : O(k) where k is no. of triplets
        int n = nums.length;
        List<List<Integer>> ansList = new ArrayList<>();
        // the optimal approach
        // sort array
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                // if not first element and prev and curr element are same,
                // then avoid that element
                continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0){
                    // take large elements
                    j++;
                }else if(sum > 0){
                    // take smaller elements
                    k--;
                }else{
                    ansList.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    //don't process this elements if j's or k's are equal to prev j's or k's
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ansList;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC : O(n^3)
        // SC : O(k)-> where k is no. of unique triplets which sum to 0
	// TLE
        int n = nums.length;
        // brute-force approach
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0;i < n;i++){
            int x = nums[i];
            for(int j = i+1;j < n;j++){
                int y = nums[j];
                for(int k = j+1;k < n;k++){
                    int z = nums[k];
                    if(x+y+z == 0){
                        List<Integer> temp = new ArrayList<>(Arrays.asList(x,y,z));
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // the better approach
        // TC : O(n^2)
        // SC : O(k)
        int n = nums.length;
        Set<List<Integer>> ansSet = new HashSet<>();
        for(int i = 0;i < n;i++){
            Set<Integer> set = new HashSet<>();//stores elements b/w (i,j)
            for(int j = i+1;j < n;j++){
                int target = -(nums[i]+nums[j]);
                if(set.contains(target)){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],target));
                    Collections.sort(list);
                    ansSet.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ansSet);
    }
}
