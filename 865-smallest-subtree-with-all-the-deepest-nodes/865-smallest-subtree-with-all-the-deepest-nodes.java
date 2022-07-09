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
    HashMap<TreeNode,TreeNode> map = new HashMap();
    TreeNode ans = null;
    public void iterate(HashSet<TreeNode> set){
        // System.out.println(set.size());
        if(set.size() == 1){
            for(TreeNode node : set){
                ans = node;
            }
            return;
        }
        HashSet<TreeNode> set2 = new HashSet();
        for(TreeNode node : set){
            set2.add(map.get(node));
        }
        iterate(set2);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode[]> queue = new LinkedList();
        HashSet<TreeNode> set = new HashSet();
        queue.offer(new TreeNode[]{root,null});
        while(!queue.isEmpty()){
            int size = queue.size();
            set.clear();
            for(int i = 0; i < size; i++){
                TreeNode[] treeArray = queue.poll();
                TreeNode child = treeArray[0];
                TreeNode parent = treeArray[1];
                if(parent != null)
                    map.put(child,parent);
                if(child.left != null){
                    queue.offer(new TreeNode[]{child.left,child});
                }  
                if(child.right != null){
                    queue.offer(new TreeNode[]{child.right,child});
                }
                set.add(child);                     
            }
        }
        iterate(set);
        // System.out.println(set.size());
        return ans;
    }
}