/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGrpEnd = dummy;
        ListNode cur = head;
        
        while (true) {
            int count = 0;
            ListNode temp = cur;
            while (temp != null && count < k) {
                count++;
                temp = temp.next;
            }
            // temp points to (k+1)th node

            if (count < k) break; // less than k nodes left

            // Reverse k nodes
            ListNode prev = null;
            ListNode grpStart = cur; // grpStart before reversing. this will be the end of grp after reversing. then make its next point to new group start.

            for (int i = 0; i < k; ++i) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            // for example 2:
            // cur will be at 4, prev at 3
            
            // prev will be first node after reverse which should be attached to prevGrpEnd.next
            prevGrpEnd.next = prev; // dummy -> 3
            // cur will point to new group start. 
            grpStart.next = cur; // 1 -> 4
            prevGrpEnd = grpStart; // 1 will become the new prevGrpEnd
        }
        return dummy.next;
    }
}