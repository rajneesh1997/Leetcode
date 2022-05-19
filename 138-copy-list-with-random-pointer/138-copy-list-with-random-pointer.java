/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> map1 = new HashMap();
        HashMap<Node,Node> map2 = new HashMap();
        Node start = head;
        Node ans = null, prev = null;
        while(start != null){
            Node n = new Node(start.val);
            if(ans == null){
                ans = n;
                prev = n;
            } else {
                prev.next = n;
                prev = prev.next;
            }
            map1.put(start,n);
            map2.put(start,start.random);
            start = start.next;
        }
        prev.next = null;
        for(HashMap.Entry<Node,Node> entry : map2.entrySet()){
            if(entry.getValue() == null){
                Node n = map1.get(entry.getKey());
                n.random = null;
            } else {
                Node n = map1.get(entry.getKey());
                n.random = map1.get(entry.getValue());
            }
        }
        return ans;
    }
}