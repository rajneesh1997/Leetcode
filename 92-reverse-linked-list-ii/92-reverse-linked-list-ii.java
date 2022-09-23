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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = head;
        ListNode prev = dummy;
        int pos = 1;
        while(ptr != null && pos != left){
            prev = ptr;
            ptr = ptr.next;
            pos++;
        }
        // stack.add(ptr);
        Stack<ListNode> stack = new Stack<>();
        while(ptr != null && pos != right+1){
            stack.add(ptr);
            ptr = ptr.next;
            pos++;
        }
        while(!stack.isEmpty()){
            prev.next = stack.pop();
            prev = prev.next;
        }
        prev.next = ptr;
        return dummy.next;
    }
}