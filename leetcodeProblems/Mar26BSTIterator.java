class BSTIterator {
    List<Integer> list;
    int itr;
    int n;
    private void inOrder(TreeNode root){
	// takes TC: O(1) and SC: O(N)
        if(root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        itr = 0;
        n = list.size();
    }
    
    public int next() {
        return list.get(itr++);
    }
    
    public boolean hasNext() {
        if(itr == n) return false;
        return true;
    }
}

class BSTIterator {
    TreeNode currNode;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        // TC : O(1) as N elements/N next calls(avg is O(1))
        // SC : O(H) where H -> Height of Tree
        currNode = root;
        stack = new Stack<>();
        pushUntilLeftIsNull(root);
    }
    private void pushUntilLeftIsNull(TreeNode root){
        if(root == null) return;
        stack.push(root);
        pushUntilLeftIsNull(root.left);
    }
    
    public int next() {
        int ans = -1;
        if(!this.hasNext()) return ans;
        currNode = stack.pop();
        ans = currNode.val;
        currNode = currNode.right;
        pushUntilLeftIsNull(currNode);
        return ans;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
