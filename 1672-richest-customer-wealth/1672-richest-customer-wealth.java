class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = -1;
        for(int[] customer:accounts){
            int amt = 0;
            for(int account:customer){
                amt += account;
            }
            ans = Math.max(ans,amt);
        }
        return ans;
    }
}