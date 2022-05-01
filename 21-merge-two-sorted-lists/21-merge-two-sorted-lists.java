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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;
        ListNode p = null, head = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(p != null)
                    p.next = list1;
                p = list1;
                list1 = list1.next;
            }
            else{
                if(p != null)
                    p.next = list2;
                p = list2;
                list2 = list2.next;
            }
            if(head == null)
                head = p;
        }
        if(list1 == null)
            p.next = list2;
        if(list2 == null)
            p.next = list1;
        return head;
    }
}