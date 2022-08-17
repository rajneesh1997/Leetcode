class Solution {
    public boolean check(HashMap<Character,Integer> t_map, HashMap<Character,Integer> s_map ){
        for(Map.Entry<Character,Integer> entry : t_map.entrySet()){
            if(s_map.get(entry.getKey()) == null)
                return false;
            if(s_map.get(entry.getKey()) < entry.getValue())
                return false;
        } 
        return true;
    }
    
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        HashMap<Character,Integer> t_map = new HashMap<>();
        HashMap<Character,Integer> s_map = new HashMap<>();
        for(int i = 0 ; i < t.length(); i++){
            char c = t.charAt(i);
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0, mm = Integer.MAX_VALUE;
        String mAns = "";
        StringBuilder ans = new StringBuilder();
        while(right <= s.length()){
            if(!check(t_map,s_map)){
                if(right == s.length()) break;
                char c = s.charAt(right);
                ans.append(c);
                right++;
                s_map.put(c,s_map.getOrDefault(c,0)+1);
            } else {
                if((right - left) < mm){
                    mm = right - left;
                    mAns = ans.toString();
                }
                char c = s.charAt(left);
                int count = s_map.get(c);
                if(count == 1){
                    s_map.remove(c);
                } else {
                    s_map.put(c,count-1);
                }
                ans.deleteCharAt(0);
                left++;
            }
        }
        // if((right - left) < mm){
        //     mm = right - left;
        //     mAns = ans.toString();
        // }
        return mAns;
    }
}