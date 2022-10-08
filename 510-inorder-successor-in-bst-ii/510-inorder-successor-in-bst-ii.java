/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    ArrayList<Node> arr = new ArrayList<>();
    public void dfs(Node node){
        if(node == null)
            return;
        dfs(node.left);
        arr.add(node);
        dfs(node.right);
    }
    public Node inorderSuccessor(Node node) {
        Node ptr = node;
        while(node.parent != null){
            node = node.parent;
        }
        dfs(node);
        int left = 0;
        int right = arr.size()-1;
        // System.out.println(ptr.val);
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(arr.get(mid).val == ptr.val){
                if(mid+1 < arr.size())
                    return arr.get(mid+1);
                else
                    return null;
            }
            if(arr.get(mid).val < ptr.val){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}