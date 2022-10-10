class Solution {
    public int longestValidParentheses(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int open = 0;
        int ans = 0;
        int n = s.length();
        int j = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                map.put(open,i);
            }
            if(ch == ')'){
                if(open == 0){
                    map.put(open,i);
                    continue;
                } else {
                    open--;
                    if(map.get(open) == null)
                        j = -1;
                    else
                        j = map.get(open);
                    ans = Math.max(ans, i-j);
                }       
            } 
        }
        return ans;
    }
}