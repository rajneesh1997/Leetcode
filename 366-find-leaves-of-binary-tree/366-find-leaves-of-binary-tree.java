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
    public int postOrder(TreeNode root){
        if(root == null)
            return -1;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        int curr = 1 + Math.max(left,right);
        
        if(curr == ans.size()){
            ans.add(new ArrayList<>());
        }
        
        ans.get(curr).add(root.val);
        return curr;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        postOrder(root);
        return ans;
    }
}