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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        if(!root->left and !root->right) return {{root->val}};
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        vector<vector<int>> ans;
        vector<int> temp;
        ans.push_back({root->val});
        bool rvs = true;
        while(q.size() > 1){
            TreeNode* node = q.front();
            q.pop();
            if(!node){
                if(rvs){
                    reverse(temp.begin(),temp.end());
                }
                rvs = !rvs;
                ans.push_back(temp);
                temp.clear();
                q.push(NULL);
            }else{
                if(node->left){
                    temp.push_back(node->left->val);
                    q.push(node->left);
                }
                if(node->right){
                    temp.push_back(node->right->val);
                    q.push(node->right);
                }
            }
        }
        return ans;
    }
};