class LRUCache {
    class DLinkedList{
        int key;
        int value;
        DLinkedList prev;
        DLinkedList next;
    }
    HashMap<Integer,DLinkedList> cache = new HashMap<>();
    int size = 0;
    int capacity = 0;
    
    DLinkedList head = new DLinkedList();
    DLinkedList tail = new DLinkedList();
    
    private void addNode(DLinkedList node){
        
        head.next.prev = node;
        node.next = head.next;
        
        head.next = node;
        node.prev = head;
         
    }
    
    private void removeNode(DLinkedList node){
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }
    
    private void moveToHead(DLinkedList node){
        
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedList popTail(){
        
        DLinkedList node = tail.prev;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.get(key) == null) return -1;
        DLinkedList node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        
        if(node != null){
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedList nNode = new DLinkedList();
            nNode.key = key;
            nNode.value = value;
            
            cache.put(key,nNode);
            addNode(nNode);
            size++;
            
            if(size > capacity){
                DLinkedList dd = popTail();
                cache.remove(dd.key);
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */