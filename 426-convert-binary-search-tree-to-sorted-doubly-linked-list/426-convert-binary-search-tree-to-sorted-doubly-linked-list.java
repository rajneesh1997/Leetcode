/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    ArrayList<Node> ans = new ArrayList<Node>();
    public void dfs(Node root){
        if(root == null)
            return;
        dfs(root.left);
        ans.add(root);
        dfs(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        int n = ans.size();
        
        // for(int i = 0; i < n; i++)
        //     System.out.println(ans.get(i).val);
        for(int i = 0; i < n-1; i++){
            Node ptr = ans.get(i);
            ptr.right = ans.get(i+1);
        }
        
        int k = n-1;
        Node at = ans.get(k);
        at.right = ans.get(0);
        
        for(int i = n-1; i > 0; i--){
            Node ptr = ans.get(i);
            ptr.left = ans.get(i-1);
        }
        
        k = 0;
        at = ans.get(k);
        at.left = ans.get(n-1);
        
        return ans.get(0);
    }
}