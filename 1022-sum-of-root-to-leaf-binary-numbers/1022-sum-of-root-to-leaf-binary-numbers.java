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
    int ans = 0;
    public int convert(String str){
        int size = str.length();
        int i = 0;
        int total = 0;
        while(i < size){
            char c = str.charAt(size-i-1);
            if(c == '1'){
                total += (1 * (int)Math.pow(2,i));
            }
            i++;
        }
        return total;
    }
    public void dfs(TreeNode root, String str){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans += convert(str+root.val);
            return;
        }
        dfs(root.left, str + root.val);
        dfs(root.right, str + root.val);
    }
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,"");
        return ans;
    }
}