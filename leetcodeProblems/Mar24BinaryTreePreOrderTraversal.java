class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // using stack: Iterative approach
        TreeNode curr = root;
        while(true){
            if(curr != null){
                stack.push(curr);
                preOrderList.add(curr.val);
                curr = curr.left;
            }
            else{
                if(stack.isEmpty()) break;
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return preOrderList;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // using morris traversal
        // takes O(1) constant space
        List<Integer> preOrderList = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                preOrderList.add(curr.val);
                curr = curr.right;//go to right
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    // go to extreme right of the subtree
                    // and the node should not equals to root(curr)
                    prev = prev.right;
                }
                if(prev.right == null){
                    // no thread linking to the root(curr)
                    // make a thread and add to list
                    prev.right = curr;
                    preOrderList.add(curr.val);
                    curr = curr.left;//do rest traversal
                }
                else{
                    // prev.right is a curr
                    prev.right = null;//cut the thread
                    curr = curr.right;//traverse on right subtree
                }
            }
        }
        return preOrderList;
    }
}
