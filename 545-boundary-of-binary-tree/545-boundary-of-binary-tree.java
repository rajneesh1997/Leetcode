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
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public void addLeaves(TreeNode root){
        if(isLeaf(root))
            arr.add(root.val);
        else {
            if(root.left != null)
                addLeaves(root.left);
            if(root.right != null)
                addLeaves(root.right);
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return arr;
        arr.add(root.val);
        if(isLeaf(root)){
            return arr;
        }
        TreeNode t = root.left;
        while(t != null){
            if(!isLeaf(t)){
                arr.add(t.val);
                if(t.left != null)
                    t = t.left;
                else
                    t = t.right;
            } else {
                break;
            }
        }
        addLeaves(root);
        t = root.right;
        Stack<Integer> stack = new Stack<>();
        while(t != null){
            if(!isLeaf(t)){
                stack.push(t.val);
                if(t.right != null)
                    t = t.right;
                else
                    t = t.left;
            } else {
                break;
            }
        }
        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }
}