class Solution {
    List<String> ans = new ArrayList<>();
    public String split(int i, int j, String s){
        String tmp = "";
        for(int k = i; k <= j; k++)
            tmp = tmp + s.charAt(k);
        return tmp;
    }
    public void f(int ind, String s, String str, List<String> wordDict){
        if(ind == s.length()){
            if(str != ""){
                ans.add(str);
            }
            return;
        }
        String tmp = "";
        for(int k = ind; k < s.length(); k++){
            tmp = split(ind, k, s);
            if(wordDict.contains(tmp)){
                if(str == ""){
                    f(k+1,s,tmp,wordDict);
                } else {
                    f(k+1,s,str + " " + tmp,wordDict);
                }
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        f(0,s,"",wordDict);
        return ans;
    }
}