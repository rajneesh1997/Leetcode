/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum = 0, carry = 0;
        sum = l1->val+l2->val;
        ListNode *ans = new ListNode(sum % 10);
        carry = sum / 10;
        ListNode *ptr1 = l1->next, *ptr2 = l2->next, *ptr3 = ans;
        while(ptr1 and ptr2){
            sum = ptr1->val + ptr2->val + carry;
            ptr3->next = new ListNode(sum%10);
            carry = sum / 10;
            ptr1 = ptr1->next;
            ptr2 = ptr2->next;
            ptr3 = ptr3->next;
        }
        while(ptr1){
            sum = ptr1->val + carry;
            ptr3->next = new ListNode(sum%10);
            carry = sum / 10;
            ptr1 = ptr1->next;
            ptr3 = ptr3->next;
        }
        while(ptr2){
            sum = ptr2->val + carry;
            ptr3->next = new ListNode(sum%10);
            carry = sum / 10;
            ptr2 = ptr2->next;
            ptr3 = ptr3->next;
        }
        if(carry)
            ptr3->next = new ListNode(carry);
        return ans;
    }
};