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
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return construct(nums,0,nums.size());
    }
    TreeNode* construct(vector<int>& nums, int l, int r){
        if(l == r) return nullptr;
        int index = maxIndex(nums,l,r);
        TreeNode* root = new TreeNode(nums[index]);
        root->left = construct(nums,l,index);
        root->right = construct(nums,index+1,r);
        return root;
    }
    int maxIndex(vector<int>& nums, int l, int r){
        int maxIndex = l;
        for(int i = l; i < r; i++){
            if(nums[maxIndex] < nums[i])
                maxIndex = i;
        }
        return maxIndex;
    }
};