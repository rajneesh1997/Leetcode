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
    void dfs(TreeNode* root, string str){
        if(!root) return;
        if(str == "L"){
            if(!root->left and !root->right) ans += root->val;
        }
        dfs(root->left, "L");
        dfs(root->right, "R");
    }
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root->left and !root->right) return 0;
        dfs(root,"");
        return ans;
    }
};