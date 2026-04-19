class Solution {
    private ListNode findKthNode(ListNode curr, int k){
        k -= 1;// first node is curr 
        while(curr != null && k-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    private void reverse(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = head.next;
        while(nxt != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        curr.next = prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // TC : O(n)
        // SC : O(1)
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null)
                    prevNode.next = temp;
                break;
            } 
            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode;// first time, therefore head is changed
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
