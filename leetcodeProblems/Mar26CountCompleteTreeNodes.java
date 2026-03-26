class Solution {
    private int getLeftNodes(TreeNode root){
        if(root == null) return 0;
        int cnt = 0;
        while(root != null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    private int getRightNodes(TreeNode root){
        if(root == null) return 0;
        int cnt = 0;
        while(root != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
    public int countNodes(TreeNode root) {
        // TC: O(log n)^2 : as height of PBT is log n
        // and therefore at the worst we find PBT here
        // h+(h-1)+(h-2)+...+1 = O(h^2) = O(log n)^2
        if(root == null) return 0;
        int lh = getLeftNodes(root);
        int rh = getRightNodes(root);
        if(lh == rh){
            // perfect binary tree
            return (int)(Math.pow(2, lh)-1);
        }
        else{
            return countNodes(root.left)+1+countNodes(root.right);// 1 for root itself
        }
    }
}
