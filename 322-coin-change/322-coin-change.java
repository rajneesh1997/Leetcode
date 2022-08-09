class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.sort(coins);
        for(int i = 1; i < amount+1; i++){
            int a = Integer.MAX_VALUE - 1;
            for(int coin : coins){
                if(i - coin >= 0){
                    if(ans[i-coin] != -1)
                        a = Math.min(a,ans[i-coin]+1);
                }
            }
            if(a == Integer.MAX_VALUE-1)
                ans[i] = -1;
            else
                ans[i] = a;
        }
        // for(int i : ans){
        //     System.out.print(i + " ");
        // }
        return ans[amount];
    }
}