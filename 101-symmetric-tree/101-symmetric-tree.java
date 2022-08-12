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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            int s =  queue.size();
            for(int i = 1; i < s; i+=2){
                TreeNode a = queue.poll();
                TreeNode b = queue.poll();
                if(a == null && b == null)
                    continue;
                if(a == null || b == null)
                    return false;
                if(a.val != b.val)
                    return false;
                if(a.val == b.val){
                    queue.offer(a.left);
                    queue.offer(b.right);
                    queue.offer(a.right);
                    queue.offer(b.left);
                }
                // System.out.println(a.val + " " + b.val);
            }
        }
        return true;
        // return findOut(root.left, root.right);
    }
    // public boolean findOut(TreeNode left, TreeNode right){
    //     if(left == null && right == null)
    //         return true;
    //     if(left == null || right == null)
    //         return false;
    //     return (left.val == right.val) && findOut(left.left,right.right) && findOut(left.right, right.left);
    // }
}