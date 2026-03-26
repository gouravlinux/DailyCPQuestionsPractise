class Solution {
    int maxSum = Integer.MIN_VALUE;
    private int solve(TreeNode root){
        if(root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int koi_ek_acha = Math.max(l, r) + root.val;
        int sirf_root_acha = root.val;
        int neeche_hi_milgaya_answer = l + r + root.val;
        maxSum = Math.max(maxSum,Math.max(koi_ek_acha,Math.max(sirf_root_acha, neeche_hi_milgaya_answer)));
        //can't return neeche_hi_milgaya_answer as this path is different now
        return Math.max(koi_ek_acha, sirf_root_acha);
    }
    public int maxPathSum(TreeNode root) {
        // Using post-order traversal to compute maximum path sums extending from children while tracking the global maximum.
        solve(root);
        return maxSum;
    }
}
