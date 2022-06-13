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
    int ans;
    public int dfs(TreeNode root,int val){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        ans = Math.max(ans,left+right);
        if(root.val == val)
            return Math.max(left,right)+1;
        return 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        ans = 0;
        dfs(root,root.val);
        return ans;
    }
}