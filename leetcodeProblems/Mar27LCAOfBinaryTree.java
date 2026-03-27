// brute solution
class Solution {
    // O(N) : TC and O(N) : SC
    private boolean findPath(TreeNode curr,TreeNode target, List<TreeNode> path){
        if(curr == null) return false;
        path.add(curr);
        if(curr == target){
            return true;
        }
        if(findPath(curr.left, target, path) || findPath(curr.right, target,path)){
            return true;
        }
        path.remove(path.size()-1);//backtrack: not in this subtree
        return false;
    }
    private void print(List<TreeNode> list){
        for(TreeNode node: list){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        print(pPath);
        print(qPath);
        int m = pPath.size();
        int n = qPath.size();
        int i = 0;
        int j = 0;
        TreeNode lca = root;
        while(i < m && j < n){
            if(pPath.get(i) == qPath.get(j)){
                lca = pPath.get(i);
            }
            else{
                break;
            }
            i++;
            j++;
        }
        return lca;
    }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // dfs travesal with constant SC
        if(root == null){
            return null;
        }
        // if root is not null
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;// as root is LCA here
        }
        if(left != null){
            // and right == null
            return left;// left is LCA
        }
        // else: right != null && left == null
        return right;
    }
}
