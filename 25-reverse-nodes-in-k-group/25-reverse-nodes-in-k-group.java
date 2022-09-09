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
        int n = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr = ptr.next;
            n++;
        }
        int groups = n / k;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ptr = dummy;
        while(groups > 0){
            groups--;
            ptr = reverse(ptr,ptr.next,k-1);
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, ListNode ptr, int k){
        ListNode tail = null;
        ListNode ptrNxt = null;
        while(k > 0){
            --k;
            tail = head.next;
            ptrNxt = ptr.next;
            ptr.next = ptrNxt.next;
            ptrNxt.next = tail;
            head.next = ptrNxt;
        }
        return ptr;
    }
}