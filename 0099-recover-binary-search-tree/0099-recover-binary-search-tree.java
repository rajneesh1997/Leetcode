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
    List<TreeNode> arr = new ArrayList<>();
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        arr.add(root);
        dfs(root.right);
    }
    public void recoverTree(TreeNode root) {
        dfs(root);
        int n = arr.size();
        int a = 0, b = n-1;
        for(int i = 1; i < n; i++){
            if(arr.get(i).val < arr.get(i-1).val){
                a = i-1;
                break;
            }
        }
        for(int i = n-1; i > -1; i--){
            if(arr.get(i).val < arr.get(i-1).val){
                b = i;
                break;
            }
        }
        
        // System.out.println(a + " " + b);
        
        int tmp = arr.get(a).val;
        arr.get(a).val = arr.get(b).val;
        arr.get(b).val = tmp;
        return;
    }
}