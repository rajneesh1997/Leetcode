class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    public String split(int i, int j, String s){
        String tmp = "";
        for(int k = i; k <= j; k++)
            tmp = tmp + s.charAt(k);
        return tmp;
    }
    public String f(int ind, String s, String str, List<String> wordDict){
        if(ind == s.length()){
            if(str != ""){
                ans.add(str);
            }
            return "";
        }
        if(map.get(str) != null) return map.get(str); 
        String tmp = "";
        for(int k = ind; k < s.length(); k++){
            tmp = split(ind, k, s);
            if(wordDict.contains(tmp)){
                if(str == ""){
                    tmp = tmp + f(k+1,s,tmp,wordDict);
                } else {
                    tmp = tmp + f(k+1,s,str + " " + tmp,wordDict);
                }
                map.put(str,tmp);
            }
        }
        return "";
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        f(0,s,"",wordDict);
        return ans;
    }
}