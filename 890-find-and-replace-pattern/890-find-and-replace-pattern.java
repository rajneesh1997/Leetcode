class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for(String str: words){
            HashMap<Character,Character> map = new HashMap();
            boolean toAdd = true;
            for(int i = 0 ; i < pattern.length(); i++){
                char from_word = str.charAt(i);
                char from_pattern = pattern.charAt(i);
                if(map.containsKey(from_pattern)){
                    if(map.get(from_pattern) != from_word){
                        toAdd = false;
                        break;
                    }
                } else {
                    map.put(from_pattern, from_word);
                }
            }
            if(toAdd){
                toAdd = true;
                boolean[] seen = new boolean[26];
                for(char p : map.values()){
                    if(seen[p -'a']){
                        toAdd = false;
                    }
                    seen[p -'a'] = true;
                }
                if(toAdd)
                    ans.add(str);
                }
        }
        return ans;
    }
}