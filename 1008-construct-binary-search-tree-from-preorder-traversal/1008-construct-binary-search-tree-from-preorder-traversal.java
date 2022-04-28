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
    public TreeNode makeTree(int start, int end, int[] preorder){
        if(start == end) return null;
        TreeNode node = new TreeNode(preorder[start]);
        int brk = end;
        for(int i = start + 1; i < end; i++){
            if(preorder[i] > preorder[start]){
                brk = i;
                break;
            }
        }
        node.left = makeTree(start+1, brk, preorder);
        node.right = makeTree(brk, end, preorder);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return makeTree(0,preorder.length,preorder);
    }
}