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
    int maxDepth = 1;
    int sum = 0;
    void dfs(TreeNode* root, int height){
        if(!root) return;
        if(height > maxDepth){
            maxDepth = height;
            sum = root->val;
        }
        else{
            if(height == maxDepth){
                sum += root->val;
            }
        }
        dfs(root->right,height+1);
        dfs(root->left,height+1);
    }
    int deepestLeavesSum(TreeNode* root) {
        dfs(root,1);
        return sum;
    }
};