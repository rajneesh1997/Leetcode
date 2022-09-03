class Solution {
    public int getMax(int i, int j, int[] arr){
        int ans = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            ans = Math.max(ans,arr[k]);
        }
        return ans;
    }
    public int f(int i, int k, int n, int[] arr, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MIN_VALUE;
        int cost = 0;
        for(int j = i; j < n && j < i+k; j++){
            cost = getMax(i,j,arr) * (j-i+1) + f(j+1,k,n,arr,dp);
            // System.out.println(cost + " " + i + " " + j);
            ans = Math.max(ans, cost);
        }
        return dp[i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0,k,n,arr,dp);
    }
}