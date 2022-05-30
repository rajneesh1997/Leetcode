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
    ArrayList<Integer> arr = new ArrayList();
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root);
        int ans = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) >= low && arr.get(i) <= high)
                ans += arr.get(i);
        }
        return ans;
    }
}