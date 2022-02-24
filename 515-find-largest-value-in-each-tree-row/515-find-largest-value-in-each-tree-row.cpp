/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(!root) return {};
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        vector<int> ans;
        int largest = INT_MIN;
        while(q.size()>1){
            TreeNode* crr = q.front();
            q.pop();
            if(!crr){
                ans.push_back(largest);
                largest = INT_MIN;
                q.push(NULL);
            }else{
                largest = max(largest,crr->val);
                if(crr->left)
                    q.push(crr->left);
                if(crr->right)
                    q.push(crr->right);
            }
        }
        ans.push_back(largest);
        return ans;
    }
};