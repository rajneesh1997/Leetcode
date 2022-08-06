/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0, kk = 0;
    public void dfs(TreeNode root){
        if(root == null || kk < 0) return;
        dfs(root.left);
        if(--kk == 0){
            ans = root.val;
            --kk;
            return;
        }
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        kk = k;
        dfs(root);
        return ans;
            
    }
}