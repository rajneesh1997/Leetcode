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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = fetchMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }
    
    public ListNode fetchMid(ListNode head){
        ListNode mid = null;
        while(head != null && head.next != null){
            mid = (mid == null) ? head : mid.next;
            head = head.next.next;
        }
        
        ListNode newStart = mid.next;
        mid.next = null;
        return newStart;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        
        tail.next = (left == null) ? right : left;
        return dummy.next;
    }
    
    
}