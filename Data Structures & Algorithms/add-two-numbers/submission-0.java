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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0) return null;

        int n1 = 0;
        int n2 = 0;

        if(l1 != null){
            n1 = l1.val;
        }

        if(l2 != null){
            n2 = l2.val;
        }

        int sum = n1 + n2 + carry;
        int newCarry = sum / 10;
        int newValue = sum % 10;

        ListNode nextNode = add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, newCarry);

        return new ListNode(newValue, nextNode);
    }



}
