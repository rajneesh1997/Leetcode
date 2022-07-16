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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode ptr1 = head, ptr2 = head.next;
        while(ptr2 != null && ptr2.next != null && ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if(ptr2 == null || ptr2.next == null) return null;
        ptr2 = ptr2.next;
        ptr1 = head;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // System.out.println(ptr1.val + " " + ptr2.val);
        return ptr1;
    }
}