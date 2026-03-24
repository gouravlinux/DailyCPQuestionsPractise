class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
	// using 2 stacks
        List<Integer> postOrderList = new ArrayList<>();
        if (root == null)
            return postOrderList;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curr = root;
        stack1.push(curr);
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
            stack2.push(curr);
        }
        while (!stack2.isEmpty()) {
            postOrderList.add(stack2.pop().val);
        }
        return postOrderList;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
	// using 1 stack: O(N) time and space complexity
        List<Integer> postOrderList = new ArrayList<>();
        if (root == null)
            return postOrderList;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    postOrderList.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        postOrderList.add(temp.val);
                    }
                } 
                else{
                    curr = temp;
                }
            }
        }
        return postOrderList;
    }
}
