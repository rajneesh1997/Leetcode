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
    bool ans = false;
    void dfs(TreeNode* root, int sum, int targetSum){
        if(!root) return;
        if(!root->left and !root->right)
            if(sum+root->val == targetSum){
                ans = true;
            }
        dfs(root->left,sum+root->val,targetSum);
        dfs(root->right,sum+root->val,targetSum);
    }
    bool hasPathSum(TreeNode* root, int targetSum) {
        dfs(root,0,targetSum);
        return ans;
    }
};