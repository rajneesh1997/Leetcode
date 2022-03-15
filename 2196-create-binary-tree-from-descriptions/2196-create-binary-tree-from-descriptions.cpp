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
    void createTree(TreeNode *root,unordered_map<int,pair<int,int>>& map,int parent){
        if(!root) return;
        if(map[parent].first == 0 and map[parent].second == 0) return;
        int left = map[parent].first;
        int right = map[parent].second;
        TreeNode *leftChild = nullptr, *rightChild = nullptr;
        if(left){
            leftChild = new TreeNode(left);
        }
        if(right){
            rightChild = new TreeNode(right);
        }
        root->left = leftChild;
        root->right = rightChild;
        createTree(leftChild,map,left);
        createTree(rightChild,map,right);
    }
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int,pair<int,int>> map;
        unordered_map<int,int> head;
        for(auto x:descriptions){
            int parent = x[0];
            int child = x[1];
            int left = x[2];
            if(left){
                map[parent].first = child;
            }else{
                map[parent].second = child;
            }
            head[child] = 1;
        }
        int treeHead = 0;
        for(auto x:map)
            if(head[x.first] == 0)
                treeHead = x.first;
        TreeNode *root = new TreeNode(treeHead);
        createTree(root,map,treeHead);
        return root;
    }
};