class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap();
        HashMap<Character, Character> map2 = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(map1.containsKey(c)){
                char e = map1.get(c);
                if(e != d)
                    return false;
            } else if(map2.containsKey(d)){
                char f = map2.get(d);
                if(f != c)
                    return false;
            }
            map1.put(c,d);
            map2.put(d,c);
        }
        return true;
    }
}