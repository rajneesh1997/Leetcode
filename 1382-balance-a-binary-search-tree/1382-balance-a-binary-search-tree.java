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
    TreeNode head = null, mainHead = null;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    public TreeNode makeTree(int left,int right){
        if(left == right) return null;
        int mid = left + ((right - left) / 2);
        TreeNode head = new TreeNode(arr.get(mid));
        head.left = makeTree(left,mid);
        head.right = makeTree(mid+1,right);
        return head;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int len = arr.size();
        return makeTree(0,len);
    }
}