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
    int sum = 0;
    void dfs(TreeNode* root,int crrValue){
        if(!root->left and !root->right){
            sum+=(crrValue*10)+root->val;
        }
        if(root->left)
            dfs(root->left,crrValue*10 + root->val);
        if(root->right)
            dfs(root->right,crrValue*10 + root->val);
        
    }
    int sumNumbers(TreeNode* root) {
        dfs(root,0);
        return sum;
        
    }
};