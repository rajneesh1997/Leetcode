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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        queue<TreeNode*> q;
        q.push(root);
        q.push(nullptr);
        double sum = 0, count =0, avg;
        while(q.size() > 1){
            TreeNode *node = q.front();
            q.pop();
            if(!node){
                avg = sum / count;
                ans.push_back(avg);
                sum = 0;
                count = 0;
                q.push(nullptr);
            }
            else{
                sum += node->val;
                count++;
                if(node->left){
                    q.push(node->left);
                }
                if(node->right){
                    q.push(node->right);
                }
            }
        }
        ans.push_back(sum / count);
        return ans;
    }
};