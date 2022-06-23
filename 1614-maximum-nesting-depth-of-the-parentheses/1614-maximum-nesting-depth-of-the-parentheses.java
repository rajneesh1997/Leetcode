class Solution {
    public int maxDepth(String s) {
        int i = 0, n = s.length();
        int ans = 0, finalAns = 0;
        while(i < n){
            char c = s.charAt(i);
            if(c == '('){
                ans++;
            } else if(c == ')'){
                ans--;
            }
            i++;
            finalAns = Math.max(finalAns, ans);
        }
        return finalAns;
    }
}