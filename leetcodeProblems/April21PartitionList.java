class Solution {
    public ListNode partition(ListNode head, int x) {
        // SC : O(1)
        // TC : O(n)
        if(head == null) return null;
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            if(curr.val < x){
                temp1.next = curr;
                temp1 = temp1.next;
                temp1.next = null;
            }
            else{
                // if(head.val >= x)
                temp2.next = curr;
                temp2 = temp2.next;
                temp2.next = null;
            }
            curr = temp;
        }
        temp1.next = l2.next;
        return l1.next;
    }
}
