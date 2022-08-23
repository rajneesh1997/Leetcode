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
    int ptr = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode f(int start, int end, int[] inorder, int[] postorder){
        if(start > end)
            return null;
        TreeNode head = new TreeNode(postorder[ptr]);
        int mid = map.get(postorder[ptr--]);
        head.right = f(mid+1, end, inorder, postorder);
        head.left = f(start, mid-1, inorder, postorder);
        return head;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int ind = 0;
        for(int ele : inorder){
            map.put(ele,ind++);
        }
        ptr = --ind;
        return f(0,postorder.length-1,inorder,postorder);
    }
}