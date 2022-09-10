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
    public TreeNode preOrder(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode head = root;
        TreeNode left = preOrder(root.left);
        TreeNode right = preOrder(root.right);
        if(left == null && right == null)
            return head;
        if(left == null && right != null){
            head.left = null;
            head.right = right;
            return head;
        }
        if(left != null && right == null){
            head.left = null;
            head.right = left;
            return head;
        }
        head.left = null;
        head.right = left;
        TreeNode ptr = left;
        while(ptr.right != null)
            ptr = ptr.right;
        ptr.right = right;
        return head;
    }
    public void flatten(TreeNode root) {
        preOrder(root);
    }
}