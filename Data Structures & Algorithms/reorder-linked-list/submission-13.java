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
    public ListNode reverse(ListNode curr){
        if(curr == null) return null;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr1 = null;
        ListNode curr2 = reverse(slow);
        ListNode next = null;
        curr1 = head;
        while(curr1 != null && curr2 != null){
            next = curr1.next;
            curr1.next = curr2;
            curr1 = next;
            if(curr2 != null){
                next = curr2.next;
                curr2.next = curr1;
                curr2 = next;
            }
        }
        if(curr1 != null){
            curr1.next = curr2;
        } else {
            curr2.next = curr1;
        }
    }
}
