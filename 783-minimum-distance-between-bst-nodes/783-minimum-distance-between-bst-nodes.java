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
    public void dfs(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        dfs(root.left,arr);
        arr.add(root.val);
        dfs(root.right,arr);
    }
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList();
        dfs(root,arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.size()-1; i++){
            ans = Math.min(ans,arr.get(i+1)-arr.get(i));
        }
        return ans;
    }
}