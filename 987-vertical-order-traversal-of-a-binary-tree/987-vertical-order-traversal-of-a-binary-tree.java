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
    HashMap<Integer,HashMap<Integer,List<Integer>>> map = new HashMap<>();
    public void dfs(TreeNode root, int col, int level){
        if(root == null)
            return;
        dfs(root.left,col-1,level+1);
        HashMap<Integer,List<Integer>> inner = map.getOrDefault(col,new HashMap<Integer,List<Integer>>());
        List<Integer> innerArr = inner.getOrDefault(level, new ArrayList<>());
        innerArr.add(root.val);
        inner.put(level,innerArr);
        map.put(col,inner);
        dfs(root.right,col+1,level+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        TreeMap<Integer,HashMap<Integer,List<Integer>>> sorted = new TreeMap<>(map);
        
        List<List<Integer>> ans = new ArrayList<>();

        for (Map.Entry<Integer,HashMap<Integer,List<Integer>>> entry : sorted.entrySet()){
            HashMap<Integer,List<Integer>> innerMap = entry.getValue();
            
            TreeMap<Integer,List<Integer>> sorted2 = new TreeMap<>(innerMap);
            
            List<Integer> tmp = new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> entry2 : sorted2.entrySet()){
                Collections.sort(entry2.getValue());
                tmp.addAll(entry2.getValue());
            }
            
            // Collections.sort(tmp);
            
            ans.add(new ArrayList<>(tmp));
            
        }
        return ans;
    }
}