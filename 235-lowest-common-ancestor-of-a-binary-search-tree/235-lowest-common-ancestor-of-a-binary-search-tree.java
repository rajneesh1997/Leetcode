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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        if(root == p || root == q) return root;
        int n1 = Math.min(p.val,q.val);
        int n2 = Math.max(p.val,q.val);
        if(root.val > n1 && root.val < n2){
            ans = root;
        } else if(root.val < n1 && root.val < n2)
            ans = lowestCommonAncestor(root.right,p,q);
        else
            ans = lowestCommonAncestor(root.left,p,q);
        return ans;
    }
}