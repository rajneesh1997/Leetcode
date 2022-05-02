/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;
        while(tortoise != hare){
            if(tortoise == null || hare == null || hare.next == null) return false;
            if(tortoise != null)
                tortoise = tortoise.next;
            if(hare != null && hare.next != null)
                hare = hare.next.next;
        }
        return true;
    }
}