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
    ListNode* swapNodes(ListNode* head, int k) {
        int l = 1;
        ListNode *ptr = head;
        unordered_map<int,ListNode*> mp;
        while(ptr){
            mp[l++]=ptr;
            ptr = ptr->next;
        }
        swap(mp[k]->val,mp[l-k]->val);
        return head;
    }
};