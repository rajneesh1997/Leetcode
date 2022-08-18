/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<TreeNode> arr = new ArrayList();
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        arr.add(root);
        dfs(root.right);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        int ind = arr.indexOf(p);
        // System.out.println(ind);
        if(ind == arr.size()-1)
            return null;
        return arr.get(ind+1);
    }
}