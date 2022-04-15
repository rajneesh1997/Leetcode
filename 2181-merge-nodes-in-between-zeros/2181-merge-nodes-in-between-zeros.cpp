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
    ListNode* mergeNodes(ListNode* head) {
        ListNode *start = head;
        ListNode *end = head->next;
        int ans = 0;
        vector<int> arr;
        while(start and end){
            if(end->val != 0){
                ans = ans + end->val;
                end = end->next;
            }else{
                arr.push_back(ans);
                ans = 0;
                start = end;
                end = end->next;
            }
        }
        ListNode *newNode = new ListNode(arr[0]);
        ListNode *head1 = newNode;
        start = newNode;
        for(int i = 1; i < arr.size(); i++){
            start->next = new ListNode(arr[i]);
            start = start->next;
        }
        return head1;
    }
};