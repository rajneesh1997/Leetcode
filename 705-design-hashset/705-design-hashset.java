class MyHashSet {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    ListNode head,crr;
    public MyHashSet() {
        head = null;
    }
    
    public void add(int key) {
        if(!contains(key)){
            if(head == null){
                head = new ListNode(key);
            } else {
                crr = head;
                while(crr.next != null)
                    crr = crr.next;
                crr.next = new ListNode(key);
            }
        }
    }
    
    public void remove(int key) {
        if(head == null) return;
        if(head.val == key){
            head = head.next;
            return;
        }
        ListNode ptr = head, prev = null;
        while(ptr != null && ptr.val != key){
            prev = ptr;
            ptr = ptr.next;
        }
        if(ptr != null){
            prev.next = ptr.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode ptr = head;
        if(head == null) return false;
        while(ptr.val != key){
            ptr = ptr.next;
            if(ptr == null) return false;
        }
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */