/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,String> map = new HashMap();
    HashMap<String,TreeNode> map1 = new HashMap();
    public void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null)
            map.put(root.left,map.get(root)+"L");
        if(root.right != null)
            map.put(root.right,map.get(root)+"R");
        dfs(root.left);
        dfs(root.right);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map.put(root,"M");
        dfs(root);
        for(TreeNode str:map.keySet()){
            map1.put(map.get(str),str);
        }
        String sp = map.get(p);
        String sq = map.get(q);
        if(sq.length() < sp.length()){
            String s = sp;
            sp = sq;
            sq = s;
        }
        String ans = "";
        for(int i = 0; i < sp.length(); i++){
            if(sp.charAt(i) == sq.charAt(i)){
                ans = ans + sp.charAt(i);
            }
            else{
                break;
            }
        }
        return map1.get(ans);
    }
}