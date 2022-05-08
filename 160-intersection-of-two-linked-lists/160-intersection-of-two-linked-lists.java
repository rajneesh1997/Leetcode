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
        HashSet<ListNode> set = new HashSet();
        ListNode start = headA;
        while(start != null){
            set.add(start);
            start = start.next;
        }
        start = headB;
        while(start != null){
            if(set.contains(start))
                return start;
            start = start.next;
        }
        return null;
    }
}