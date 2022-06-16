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
    public ListNode swap(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode tmp = head;
        head = head.next;
        tmp.next = head.next;
        head.next = tmp;
        tmp.next = swap(head.next.next);
        return head;
    }
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
}