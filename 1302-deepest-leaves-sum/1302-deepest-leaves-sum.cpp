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
    int ans = 0;
    void dfs(TreeNode* root, int level, int depth){
        if(!root) return;
        if(level ==  depth){
            ans += root->val;
        }
        dfs(root->left,level+1,depth);
        dfs(root->right,level+1,depth);
    }
    int height(TreeNode* root){
        if(!root) return 0;
        return 1 + max(height(root->left),height(root->right));
    }
    int deepestLeavesSum(TreeNode* root) {
        int depth = height(root);
        dfs(root,1,depth);
        return ans;
    }
};