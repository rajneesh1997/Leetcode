class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c) == false){
                map.put(c,0);
            } else {
                int a  = map.get(c);
                a++;
                map.put(c,a);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 0) return i;
        }
        return -1;
    }
}