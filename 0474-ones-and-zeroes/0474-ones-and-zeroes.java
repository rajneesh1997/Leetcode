class Solution {
    HashMap<String, Pair<Integer,Integer>> map = new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        for(String str : strs){
            map.put(str, count(str));
        }
        int n2 = strs.length;
        int[][][] dp = new int[n2][m+1][n+1];
        for(int[][] row2 : dp){
            for(int[] row : row2){
                Arrays.fill(row,-1);
            }
        }
        return f(n2-1,m,n,strs,dp);
    }
    public Pair<Integer,Integer> count(String str){
        int one = 0;
        int zero = 0;
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i++);
            if(ch == '0')
                zero++;
            else if(ch == '1')
                one++;
        }
        return new Pair(zero,one);
    }
    public int f(int ind, int m, int n, String[] strs, int[][][] dp){
        if(ind == -1){
            return 0;
        }
        if(dp[ind][m][n] != -1) return dp[ind][m][n];
        int notTake = f(ind-1,m,n,strs,dp);
        int take = 0;
        String str = strs[ind];
        Pair<Integer,Integer> p = map.get(str);
        Integer zero = p.getKey();
        Integer one = p.getValue();
        if(zero <= m && one <= n){
            take = 1 + f(ind-1,m-zero,n-one,strs,dp);
        }
        return dp[ind][m][n] = Math.max(notTake, take);
    }
}