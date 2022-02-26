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
    int findBottomLeftValue(TreeNode* root) {
        if(!root->left and !root->right) return root->val;
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        int ans;
        while(q.size() > 1){
            TreeNode *node = q.front();
            q.pop();
            if(!node){
                if(q.front()){
                    ans = q.front()->val;
                }
                q.push(NULL);
            }
            else{
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
            }
        }
        return ans;
    }
};