class WordDictionary {
    class TrieNode {
        TrieNode[] nodes;
        boolean isEnd;
        
        TrieNode(){
            nodes = new TrieNode[26];
            isEnd = false;
        }
        
        public boolean containsKey(char ch){
            return nodes[ch-'a'] != null;
        }
        
        public TrieNode get(char ch){
            return nodes[ch-'a'];
        }
        
        public void put(char ch, TrieNode node){
            nodes[ch-'a'] = node;
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean getEnd(){
            return isEnd;
        }
    }
    
    TrieNode head = new TrieNode();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode ptr = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!ptr.containsKey(c))
                ptr.put(c, new TrieNode());
            ptr = ptr.get(c);
        }
        ptr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode ptr = head;
        return searchF(0,word,ptr);
    }
    
    public boolean searchF(int i,String word,TrieNode ptr){
        if(i == word.length()){
            return ptr.getEnd();
        }
        char ch = word.charAt(i);
        boolean ans = false;
        if(ch != '.'){
            if(ptr.containsKey(ch)){
                ans = true && searchF(i+1,word,ptr.get(ch));
            } else {
                return false;
            }
        } else {
            for(int ii = 0; ii < 26; ii++){
                ch = (char)('a'+ii);
                if(ptr.containsKey(ch)){
                    ans = ans || searchF(i+1,word,ptr.get(ch));
                }
            }
        }
        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */