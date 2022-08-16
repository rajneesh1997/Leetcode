class TrieNode {
    TrieNode[] links;
    boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
    
    public void setEnd(){
        isEnd = true;
    }
}

class Trie {
    TrieNode head = new TrieNode();
    
    public Trie() {
        
    }
    
    public void insert(String word) {
        TrieNode ptr = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!ptr.containsKey(c)){
                ptr.put(c, new TrieNode());
            }
            ptr = ptr.get(c);
        }
        ptr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode ptr = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ptr.containsKey(c))
                ptr = ptr.get(c);
            else
                return false;
        }
        return ptr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ptr = head;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ptr.containsKey(c))
                ptr = ptr.get(c);
            else
                return false;
        }
        return ptr != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */