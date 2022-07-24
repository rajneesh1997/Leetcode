class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList();
        if(s.length() < p.length()) return ans;
        int[] phash = new int[26];
        int[] shash = new int[26];
        for(int i = 0; i < p.length(); i++){
            phash[p.charAt(i)-'a']++;
            shash[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(phash,shash)) ans.add(0);
        for(int i = p.length(); i < s.length(); i++){
            shash[s.charAt(i)-'a']++;
            shash[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(phash,shash)) ans.add(i-p.length()+1);
        }
        return ans;
    }
}