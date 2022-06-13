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
    int ans = 0;
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int arr_left = 0, arr_right = 0;
        if(root.left != null && root.val == root.left.val)
            arr_left += left + 1;
        if(root.right != null && root.val == root.right.val)
            arr_right += right + 1;
        ans = Math.max(ans,arr_left + arr_right);
        return Math.max(arr_left,arr_right);
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
}