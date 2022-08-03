class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        boolean flag = false;
        HashMap<String,Integer> map = new HashMap();
        HashSet<String> set = new HashSet();
        for(String word : words){
            set.add(word);
            map.put(word, map.getOrDefault(word,0)+1);
        }
        for(String word : set){
            if(map.containsKey(word)){
                // System.out.println(word + " " + map.get(word));
                String rev_word = "" + word.charAt(1) + word.charAt(0);
                if(word.equals(rev_word)){
                    int count = map.get(word);
                    ans += (count/2) * 4;
                    if(count % 2 == 1)
                        flag = true;
                    map.remove(word);
                } else {
                    if(map.containsKey(rev_word)){
                        ans += (Math.min(map.get(word), map.get(rev_word))) * 4;
                        map.remove(word);
                    }
                }
            }
        }
        if(flag)
            ans += 2;
        return ans;
    }
}