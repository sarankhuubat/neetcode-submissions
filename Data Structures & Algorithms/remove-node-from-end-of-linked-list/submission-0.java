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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode tmp = head;

        while(tmp != null){
            nodes.add(tmp);
            tmp = tmp.next;
        }

        int nth = nodes.size() - n;
        if(nth == 0)
            return head.next;
        nodes.get(nth - 1).next = nodes.get(nth).next;

        return head;
    }
}
