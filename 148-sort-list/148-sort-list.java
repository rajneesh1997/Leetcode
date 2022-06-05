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
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }
    
    public ListNode getMid(ListNode head){
        ListNode midprev = null;
        while(head != null && head.next != null){
            midprev = (midprev == null) ? head : midprev.next;
            head = head.next.next;
        }
        ListNode mid = midprev.next;
        midprev.next = null;
        return mid;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
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
        return dummyHead.next;
    }
}