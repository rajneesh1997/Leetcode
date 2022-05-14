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
    public int[] dfs(TreeNode root){
        int[] arr = new int[2];
        if(root == null){
            return arr;
        }
        if(root.left == null && root.right == null){
            ans++;
            arr[0] = root.val;
            arr[1] = 1;
            return arr;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int tot = left[1] + right[1] + 1;
        int s = left[0] + right[0] + root.val;
        // int tot = 1, s = root.val;
        // if(left[1] != 0){
        //     s += left[0];
        //     tot += left[1];
        // }
        // if(right[1] != 0){
        //     s += right[0];
        //     tot += right[1];
        // }
        if(s/tot == root.val)
            ans++;
        arr[0] = s;
        arr[1] = tot;
        return arr;
            
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}