class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = "" + num;
        int ans = 0;
        for(int i = 0; i < numStr.length()-k+1; i++){
            String str = numStr.substring(i,i+k);
            int div = Integer.parseInt(str);
            if(div != 0){
                if(num % div == 0)
                    ans++;
            }
        }
        return ans;
    }
}