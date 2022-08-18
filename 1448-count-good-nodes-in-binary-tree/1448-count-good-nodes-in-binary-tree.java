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
    List<Integer> arr = new ArrayList();
    public void dfs(TreeNode root, int val){
        arr.add(val);
        int crr = root.val;
        boolean inc = true;
        for(Integer i : arr){
            if( i > crr){
                inc = false;
                break;
            }
        }
        if(inc)
            ans++;
        // for(Integer i : arr){
        //     System.out.print(i+ " ");
        // }
        // System.out.println();
        if(root.left != null)
            dfs(root.left,root.left.val);
        if(root.right != null)
            dfs(root.right, root.right.val);
        arr.remove(arr.size()-1);
        return;
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return ans;
    }
}