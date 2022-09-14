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
    List<List<Integer>> ans = new ArrayList<>();
    public TreeNode dfs(TreeNode root, List<Integer> tmp){
        if(root.left == null && root.right == null){
            tmp.add(root.val);
            // root = new TreeNode();
            return null;
        }
        if(root.left != null)
            root.left = dfs(root.left,tmp);
        if(root.right != null)
            root.right = dfs(root.right,tmp);
        return root;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        TreeNode dummy = new TreeNode();
        dummy.right = root;
        while(dummy.right != null){
            List<Integer> tmp = new ArrayList<>();
            dfs(dummy,tmp);
            ans.add(tmp);
        }
        // ans.add(new ArrayList<>(root.val));
        return ans;
    }
}