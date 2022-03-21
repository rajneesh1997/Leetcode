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
    bool ans = true;
    void dfs(TreeNode *root, int val){
        if(!root) return;
        if(root->val != val){
            ans = false;
            return;
        }
        dfs(root->left,val);
        dfs(root->right,val);
    }
    bool isUnivalTree(TreeNode* root) {
        dfs(root,root->val);
        return ans;
    }
};