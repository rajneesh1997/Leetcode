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
    List<List<Integer>> ans = new ArrayList();
    List<Integer> arr = new ArrayList();
    public void dfs(TreeNode root, int targetSum){
        if(root == null) return;
        arr.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                ans.add(new ArrayList(arr));
            }
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        arr.remove(arr.size()-1);
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ans;
    }
}