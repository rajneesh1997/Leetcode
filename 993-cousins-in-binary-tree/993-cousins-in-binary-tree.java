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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode[]> queue = new LinkedList();
        queue.offer(new TreeNode[]{root,null});
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean x_found = false, y_found = false;
            TreeNode x_parent = null, y_parent = null;
            for(int i = 0; i < size; i++){
                TreeNode[] nodes = queue.poll();
                int parent,child;
                if(nodes[1] != null)
                    parent = nodes[1].val;
                child = nodes[0].val;
                if(child == x){
                    x_found = true;
                    x_parent = nodes[1];
                }else if(child == y){
                    y_found = true;
                    y_parent = nodes[1];
                }
                if(nodes[0].left != null)
                    queue.offer(new TreeNode[]{nodes[0].left,nodes[0]});
                if(nodes[0].right != null)
                    queue.offer(new TreeNode[]{nodes[0].right,nodes[0]});
            }
            if(x_found && y_found){
                if(x_parent.val == y_parent.val){
                    return false;
                } else {
                    return true;
                }
            } else if((x_found && !y_found) || (!x_found && y_found))
                return false;
        }
        return true;
    }
}