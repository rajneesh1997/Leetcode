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
    ArrayList<Integer> list = new ArrayList<>();
    int ans = 0;
    public void dfs(TreeNode root, int targetSum){
        if(root == null) return;
        
        list.add(root.val);
        
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        
        double result = 0;
        for(int i = list.size()-1; i > -1; i--){
            result += list.get(i);
            if(result == (double)targetSum)
                ans++;
        }
        list.remove(list.size()-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ans;
    }
}