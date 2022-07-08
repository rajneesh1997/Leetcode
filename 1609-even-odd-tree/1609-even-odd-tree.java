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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0) return false;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        ArrayList<Integer> arr = new ArrayList();
        while(!queue.isEmpty()){
            // System.out.println(queue.size());
            int size = queue.size();
            arr.clear();
            for(int i = 0 ; i < size; i++){
                TreeNode node = queue.poll();
                arr.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(level % 2 == 0){
                // System.out.println(level + " even");
                if(arr.size() == 1){
                    int x = Integer.valueOf(arr.get(0));
                    if( x % 2 == 0)
                        return false;
                }
                for(int i = 1; i < arr.size(); i++){
                    int x = Integer.valueOf(arr.get(i-1));
                    int y = Integer.valueOf(arr.get(i));
                    if((x >= y) || (x % 2 == 0) || (y % 2 == 0))
                        return false;
                    // System.out.println(x + " " + y);
                }
            } else {
                // System.out.println(level + " odd");
                if(arr.size() == 1){
                    int x = Integer.valueOf(arr.get(0));
                    if( x % 2 == 1)
                        return false;
                }
                for(int i = 1; i < arr.size(); i++){
                    int x = Integer.valueOf(arr.get(i-1));
                    int y = Integer.valueOf(arr.get(i));
                    if((y >= x) || (x % 2 == 1) || (y % 2 == 1))
                        return false;
                    // System.out.println(x + " " + y);
                }
            }
            ++level;
        }
        return true;
    }
}