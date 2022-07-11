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
    int mm = Integer.MIN_VALUE;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        int ans = root.val;
        if(map.containsKey(ans)){
            int k = map.get(ans);
            ++k;
            mm = Math.max(mm,k);
            map.put(ans,k);
        } else {
            map.put(ans, 1);
            mm = Math.max(mm,1);
        }
        dfs(root.right);
    }
    public int[] findMode(TreeNode root) {
        dfs(root);
        ArrayList<Integer> arr = new ArrayList();
        for(int key : map.keySet()){
            if(map.get(key) == mm)
                arr.add(key);
        }
        int[] ans = arr.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}