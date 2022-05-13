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
    ArrayList<String> ans = new ArrayList();
    public void dfs(TreeNode root, String str){
        if(root == null) return;
        char c = (char)(97+root.val);
        str = c + str;
        if(root.left == null && root.right == null){
            ans.add(str);
            return;
        }
        dfs(root.left, str);
        dfs(root.right, str);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        Collections.sort(ans);
        return ans.get(0);
    }
}