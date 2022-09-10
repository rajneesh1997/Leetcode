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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer ans = 0;
        
        queue.addLast(new Pair<>(root,0));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> head = queue.getFirst();
            Integer size = queue.size();
            Pair<TreeNode,Integer> elem = null;
            for(int i = 0; i < size; i++){
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if(node.left != null){
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                }
                if(node.right != null){
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
                }
            }
            
            ans = Math.max(ans, elem.getValue() - head.getValue() + 1); 
        }
        
        return ans;
    }
}