class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        if( n == 1) return ans;
        String str = "";
        for(int i = 2; i <= n; i++){
            str = "";
            int count = 0;
            for(int j = ans.length()-1; j > -1; j--){
                if(str.equals("")){
                    str += ans.charAt(j);
                    count++;
                    continue;
                }
                else{
                    if(ans.charAt(j) == ans.charAt(j+1)){
                        count++;
                    }
                    else{
                        str = count + str;
                        str = ans.charAt(j) + str;
                        count = 1;
                    }
                }
            }
            if(count > 0){
                str = count + str;
            }
            ans = str;
        }
        return ans;
    }
}