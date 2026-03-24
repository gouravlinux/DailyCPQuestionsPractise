class Solution {
    TreeNode prev;//initially pointing to null
    public void flatten(TreeNode root) {
        // recursive solution: O(N) time and space both
        if(root == null) return;
        // do reverse postorder: right, left, root
        flatten(root.right);
        flatten(root.left); 
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
class Solution {
    TreeNode prev;//initially pointing to null
    public void flatten(TreeNode root) {
        if(root == null) return;
        // iterative solution using stack: O(N) time and space complexity
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
            if(!stack.isEmpty()) curr.right = stack.peek();
            curr.left = null;
        }
    }
}
class Solution {
    public void flatten(TreeNode root) {
        // somewhat morris approach: O(N) time and O(1) space
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
