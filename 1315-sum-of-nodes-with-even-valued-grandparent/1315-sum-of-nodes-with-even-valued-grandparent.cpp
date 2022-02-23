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
    void dfs(TreeNode* child, TreeNode* parent, TreeNode* grandParent){
        if(!child) return;
        if(grandParent && (grandParent->val % 2 == 0)){
            ans += child->val;
        }
        dfs(child->left,child,parent);
        dfs(child->right,child,parent);
    }
    int sumEvenGrandparent(TreeNode* root) {
        dfs(root,NULL,NULL);
        return ans;
    }
};