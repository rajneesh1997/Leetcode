class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, sum = 0, res = 0;
        int n = neededTime.length;
        for(int i = 0; i < n; i++){
            if(i !=  0 && colors.charAt(i) != colors.charAt(i-1)){
                ans += sum - res;
                sum = 0;
                res = 0;
            }
            sum += neededTime[i];
            res = Math.max(res, neededTime[i]);
        }
        ans += sum - res;
        return ans;
    }
}