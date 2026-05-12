/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> list = new ArrayList<>();
        HashSet<ListNode> nodeSet = new HashSet<>();

        ListNode cur = headA;
        while(cur != null){
            nodeSet.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while(cur != null){
            if(nodeSet.contains(cur)){
                return new ListNode(cur.val);
            }
            cur = cur.next;
        }

        return null;
    }
}