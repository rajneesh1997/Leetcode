/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans = new ArrayList();
    public void bfs(Node root){
        Stack<Node> que = new Stack();
        que.push(root);
        while(!que.isEmpty()){
            Node child = que.pop();
            ans.add(child.val);
            for(int i = child.children.size()-1; i > -1; i--)
                que.push(child.children.get(i));
        }
    }
    public List<Integer> preorder(Node root) {
        if(root == null) return ans;
        bfs(root);
        return ans;
    }
}