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
    HashMap<Integer,Integer> map = new HashMap();
    int preorderIndex = 0;
    public TreeNode arrayToTree(int[] preorder, int i, int j){
        if(i > j) return null;
        int root = preorder[preorderIndex++];
        TreeNode node = new TreeNode(root);
        node.left = arrayToTree(preorder, i, map.get(root)-1);
        node.right = arrayToTree(preorder, map.get(root)+1, j);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return arrayToTree(preorder, 0, preorder.length-1);
    }
}