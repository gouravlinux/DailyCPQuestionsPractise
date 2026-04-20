class Solution {
    private ListNode findNextNonDuplicate(ListNode curr){
        if(curr == null || curr.next == null) return null;
        int value = curr.val;
        while(curr != null){
            if(value != curr.val){
                return curr;
            }
            else{
                curr = curr.next;
            }
        }
        return null;
    }
    public ListNode deleteDuplicates(ListNode head) {
        // TC : O(n)
        // Extra space : O(1)
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.next == null){
                break;
            }
            if(curr.val != curr.next.val){
                prev = curr;
                curr = curr.next;
                continue;
            }
            else{
                // if curr.val == curr.next.val
                prev.next = findNextNonDuplicate(curr);
                curr = prev.next;
                continue;
            }
        }
        return dummy.next;
    }
}
