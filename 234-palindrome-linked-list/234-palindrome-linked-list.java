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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode start = head;
        int len = 0;
        while(start != null){
            len++;
            start = start.next;
        }
        Stack<Integer> st = new Stack();
        ListNode tor = head, hare = head;
        while(hare != null && hare.next != null){
            st.push(tor.val);
            tor = tor.next;
            hare = hare.next.next;
        }
        if(len % 2 == 1)
            tor = tor.next;
        while(tor != null){
            if(st.peek() != tor.val) return false;
            st.pop();
            tor = tor.next;
        }
        return true;
    }
}