class Solution {
    private int findLength(ListNode head){
        int n = 0;
        while(head != null){
            n++;
            head = head.next;
        }
        return n;
    }
    public ListNode rotateRight(ListNode head, int k) {
        // TC : O(n)+O(n-k)+O(k)
        // SC : O(1)
        if(head == null || head.next == null) return head;
        int n = findLength(head);
        k = k % n;
        if(k == 0){
            return head;// no need to do anything
        }
        int rem = n - k;
        ListNode prev = null;
        ListNode curr = head;
        while(--rem > 0){
            prev = curr;
            curr = curr.next;
        }
        ListNode nxt = curr.next;
        curr.next = null;
        ListNode temp = nxt;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return nxt;
    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // TC : O(n)+O(n-k)
        // SC : O(1)
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }
        k = k % n;
        if(k == 0) return head;//no need to make any change
        tail.next = head;// make it a circular LL
        ListNode curr = head;
        int rem = n - k;
        while(curr != null && --rem > 0){
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
