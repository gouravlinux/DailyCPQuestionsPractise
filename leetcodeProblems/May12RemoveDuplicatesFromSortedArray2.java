class Solution {
    public int removeDuplicates(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        int n = nums.length;
        // in-place algo
        int i = 0;
        int j = 0;
        while(j < n){
            int count = 1;//count no. of occurances of nums[j]
            while((j+1 < n) && nums[j] == nums[j+1]){
                j++;
                count++;
            }
            count = Math.min(2, count);
            while(count-- > 0){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        // TC : O(n)
        // SC : O(n) where it is possible to have all elements unique
        // LinkedHashMap opns like get, put, getOrDefault takes O(1) time
        // using extra space
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (int key : map.keySet()) {
            if (map.get(key) >= 2) {
                int cnt = 2;
                while (cnt-- > 0) {
                    nums[i++] = key;
                }
            } else {
                nums[i++] = key;
            }
        }
        return i;
    }
}
