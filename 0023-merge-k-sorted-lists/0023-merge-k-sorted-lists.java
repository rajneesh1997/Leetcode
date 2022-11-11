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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = null;
        for(int i = 0; i < lists.length; i++){
            dummy = dummy == null ? lists[i] : merge(dummy,lists[i]);
        }
        return dummy;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode sentinel = new ListNode();
        ListNode tail = sentinel;
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
        return sentinel.next;
    }
}