class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // using DFS
        if(p == null && q == null){
            return true;
        }
	// now we can write
	// if(p == null || q == null){
	// 	return false;
	// }
	// same as the below condition
        if((p == null && q != null) || (p !=null && q == null) || (p.val != q.val)){
            return false;
        }
        if(!isSameTree(p.left, q.left)){
            return false;
        }
        return isSameTree(p.right, q.right);
	// above condition's simplified version: 
	// return isSame(p.left,q.left) && isSame(p.right, q.right)
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // using BFS
        Queue<TreeNode> pQue = new LinkedList<>();
        Queue<TreeNode> qQue = new LinkedList<>();
        pQue.add(p);
        qQue.add(q);
        while(!pQue.isEmpty() && !qQue.isEmpty()){
            TreeNode pItem = pQue.poll();
            TreeNode qItem = qQue.poll();
            if(pItem == null && qItem == null){
                continue;
            }
            if((pItem != null && qItem == null) || (pItem == null && qItem != null) || (pItem.val != qItem.val)){
                return false;
            }
            if(pItem != null){
                pQue.add(pItem.left);
                pQue.add(pItem.right);
            }
            if(qItem != null){
                qQue.add(qItem.left);
                qQue.add(qItem.right);
            }
        }
        return true;
    }
}
