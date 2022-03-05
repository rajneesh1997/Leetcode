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
    int height(TreeNode* root){
        if(!root) return 0;
        return 1 + max(height(root->left),height(root->right));
    }
    int countNodes(TreeNode* root) {
        if(!root) return 0;
        int level = height(root);
        if(level == 1){
            return root->val;
        }
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        int nodes = 0, treeHeight = 0;
        while(!q.empty()){
            TreeNode* node = q.front();
            q.pop();
            if(!node){
                treeHeight++;
                if(treeHeight == level)
                    break;
                q.push(NULL);
            }
            else{
                nodes++;
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
            }
        }
        return nodes;
    }
};