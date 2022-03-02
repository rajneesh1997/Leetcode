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
    vector<int> rightSideView(TreeNode* root) {
        if(!root) return {};
        vector<int> ans;
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        while(q.size()>1){
            TreeNode* node = q.front();
            q.pop();
            if(!q.front()){
                ans.push_back(node->val);
            }
            if(node){
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
            }
            else{
                q.push(NULL);
            }
        }
        return ans;
    }
};