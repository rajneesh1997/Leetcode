class BrowserHistory {
    public class Node{
        String str;
        Node prev, next;
        Node(String val){
            this.str = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head,crr;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        crr = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        crr.next = node;
        node.prev = crr;
        crr = node;
    }
    
    public String back(int steps) {
        while(crr.prev != null && steps-- > 0){
            crr = crr.prev;
        }
        return crr.str;
    }
    
    public String forward(int steps) {
        while(crr.next != null && steps-- > 0){
            crr = crr.next;
        }
        return crr.str;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */