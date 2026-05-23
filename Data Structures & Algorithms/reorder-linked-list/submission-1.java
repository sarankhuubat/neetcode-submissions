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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dump = head;
        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;

        ListNode secondHalf = null;
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = secondHalf;
            secondHalf = slow;
            slow = tmp;
        }

        while(secondHalf != null && head != null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = secondHalf.next;
            head.next = secondHalf;
            if (tmp1 == null) break;
            secondHalf.next = tmp1;
            head = tmp1;
            secondHalf = tmp2;
        }
    }
}
