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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        Stack<TreeNode> out = new Stack();
        ArrayList<Integer> ans = new ArrayList();
        if(root == null)
            return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            out.push(node);
            if(node.left != null)
                st.push(node.left);
            if(node.right != null)
                st.push(node.right);
        }
        while(!out.isEmpty()){
            TreeNode node = out.pop();
            ans.add(node.val);
        }
        return ans;
    }
}