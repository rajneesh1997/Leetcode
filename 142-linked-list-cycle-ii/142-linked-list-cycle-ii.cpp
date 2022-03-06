/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(!head) return {};
        unordered_set<ListNode*> st;
        ListNode *node = head, *ans;
        while(st.count(node)==0){
            if(!node->next) return NULL;
            st.insert(node);
            node = node->next;
            ans = node;
        }
        return ans;
    }
};