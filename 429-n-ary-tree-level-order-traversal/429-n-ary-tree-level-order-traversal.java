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
    List<List<Integer>> _ans = new ArrayList();
    public void bfs(Node root){
        Queue<Node> que = new LinkedList();
        que.offer(root);
        que.offer(null);
        while(que.size() > 1){
            Node child = que.poll();
            if(child == null){
                _ans.add(new ArrayList(ans));
                ans.clear();
                que.offer(null);
            } else {
                ans.add(child.val);
                for(Node c : child.children)
                    que.offer(c);
            }  
        }
        _ans.add(new ArrayList(ans));
    }
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return _ans;
        bfs(root);
        return _ans;
    }
}