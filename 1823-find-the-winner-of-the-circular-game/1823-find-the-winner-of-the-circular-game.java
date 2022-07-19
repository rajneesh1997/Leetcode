class Solution {
    public class Node{
        int val;
        Node next;
        Node(int val) {this.val = val;}
    }
    int ans;
    public void recur(Node ptr, int k){
        if(k < 1) return;
        if(ptr.val == ptr.next.val) {ans = ptr.val; return;}
        Node p = ptr, prev = null;
        for(int i = 1; i < k; i++){
            prev = p;
            p = p.next;
        }
        prev.next = p.next;
        recur(p.next,k);
    }
    public int findTheWinner(int n, int k) {
        if(k == 1) return n;
        Node head = null, prev = null;
        for(int i = 1; i <= n; i++){
            if(head == null){
                Node node = new Node(i);
                head = node;
                prev = node;
            } else {
                prev.next = new Node(i);
                prev = prev.next;
            }
        }
        prev.next = head;
        recur(head,k);
        return ans;
    }
}