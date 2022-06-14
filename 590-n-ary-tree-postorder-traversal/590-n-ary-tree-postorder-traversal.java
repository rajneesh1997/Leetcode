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
    public void iterative(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack();
        st.push(root);
        while(!st.isEmpty()){
            Node node = st.pop();
            ans.add(node.val);
            for(Node child : node.children)
                st.push(child);
        }
    }
    public List<Integer> postorder(Node root) {
        iterative(root);
        Collections.reverse(ans);
        return ans;
    }
}