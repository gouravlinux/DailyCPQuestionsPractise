class Solution {
    List<List<Integer>> res;
    int n;
    Set<Integer> visited;

    private void solve(int[] nums, List<Integer> temp) {
        // base case
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(nums[i])) {
                temp.add(nums[i]);//include
                visited.add(nums[i]);
                solve(nums, temp);//explore
                //backtrack
                temp.remove(temp.size() - 1);
                visited.remove(nums[i]);
                // not taken then explored(excluded and explored case) is handled by for loop
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new HashSet<>();
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, temp);
        return res;
    }
}
class Solution {
    List<List<Integer>> res;
    int n;

    private void solve(int start, List<Integer> temp) {
        // base case
        if (start == n - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            // swap elements at idx and i
            Collections.swap(temp, i, start);
            // explore further
            solve(start + 1, temp);
            // backtrack
            Collections.swap(temp, start, i);
            // exploration after exclusion done by for loop
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        //approach 2
        n = nums.length;
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        solve(0, temp);
        return res;
    }
}
